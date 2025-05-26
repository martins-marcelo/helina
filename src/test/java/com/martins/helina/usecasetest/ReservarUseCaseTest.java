package com.martins.helina.usecasetest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.martins.helina.adapter.sns.ReservaSNSClient;
import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.mapper.EstabelecimentoDTOMockMapper;
import com.martins.helina.mapper.ReservaDTOMockMapper;
import com.martins.helina.service.EstabelecimentoService;
import com.martins.helina.service.ReservaService;
import com.martins.helina.usecase.ReservarUseCase;


public class ReservarUseCaseTest {

    @Mock
    private EstabelecimentoService estabelecimentoService;
    @Mock
    private ReservaService reservaService;
    @Mock
    private ReservaSNSClient reservaSNSClient;
    @InjectMocks
    private ReservarUseCase reservarUseCase;





    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void executeStatusReservaAceitaTipoReservaAutoTest() throws Exception {
        ReservaDTOMockMapper reservaDTOMapper = new ReservaDTOMockMapper();
        EstabelecimentoDTOMockMapper estabelecimento = new EstabelecimentoDTOMockMapper();
        EstabelecimentoDTO estabelecimentoDTO = estabelecimento.estabelecimentoDTOMapperTipoReservaAuto();
        ReservaDTO reservaDTO = reservaDTOMapper.reservaDTOMapperStatusAceita();
        when(estabelecimentoService.buscarPorId(reservaDTO.getIdEstabelecimento()))
                .thenReturn(estabelecimentoDTO);
        reservaService.criar(reservaDTO);
        verify(reservaService, times(1)).criar(reservaDTO);
        reservaSNSClient.notificarReservaEstabelecimento();
        verify(reservaSNSClient, times(1)).notificarReservaEstabelecimento();
        reservarUseCase.execute(reservaDTO);
    }

    @Test
    public void executeStatusReservaSolicitadoTipoReservaDiferenteDeAutoTest() throws Exception {
        ReservaDTOMockMapper reservaDTOMapper = new ReservaDTOMockMapper();
        EstabelecimentoDTOMockMapper estabelecimento = new EstabelecimentoDTOMockMapper();
        EstabelecimentoDTO estabelecimentoDTO = estabelecimento.estabelecimentoDTOMapperTipoReservaAvaliar();
        ReservaDTO reservaDTO = reservaDTOMapper.reservaDTOMapperStatusSolicitada();
        when(estabelecimentoService.buscarPorId(reservaDTO.getIdEstabelecimento()))
                .thenReturn(estabelecimentoDTO);
        reservaService.criar(reservaDTO);
        verify(reservaService, times(1)).criar(reservaDTO);
        reservaSNSClient.notificarReservaEstabelecimento();
        verify(reservaSNSClient, times(1)).notificarReservaEstabelecimento();
        reservarUseCase.execute(reservaDTO);

    }

}
