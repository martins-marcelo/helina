package com.martins.helina.usecasetest;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.adapter.db.ReservaDBClient;
import com.martins.helina.adapter.sns.ReservaSNSClient;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.entrypoint.dto.enums.StatusReservaEnum;
import com.martins.helina.mapper.EstabelecimentoDTOMapper;
import com.martins.helina.mapper.ReservaDTOMapper;
import com.martins.helina.usecase.ReservarUseCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


public class ReservarUseCaseTest {

    @Mock
    private EstabelecimentoDBClient estabelecimentoClient;
    @Mock
    private ReservaDBClient reservaDBClient;
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
        ReservaDTOMapper reservaDTOMapper = new ReservaDTOMapper();
        EstabelecimentoDTOMapper estabelecimento = new EstabelecimentoDTOMapper();
        EstabelecimentoDTO estabelecimentoDTO = estabelecimento.estabelecimentoDTOMapperTipoReservaAuto();
        ReservaDTO reservaDTO = reservaDTOMapper.reservaDTOMapperStatusAceita();
        when(estabelecimentoClient.recuperarEstabelecimento(reservaDTO.getIdEstabelecimento()))
                .thenReturn(estabelecimentoDTO);
        when(reservaDBClient.inserirReserva(reservaDTO)).thenReturn(reservaDTO);
        ReservaDTO res = reservaDBClient.inserirReserva(reservaDTO);
        verify(reservaDBClient, times(1)).inserirReserva(reservaDTO);
        reservaSNSClient.notificarReservaEstabelecimento();
        verify(reservaSNSClient, times(1)).notificarReservaEstabelecimento();
        ReservaDTO result = reservarUseCase.execute(reservaDTO);
        Assert.assertEquals(StatusReservaEnum.ACEITA, result.getStatusReserva());
    }

    @Test
    public void executeStatusReservaSolicitadoTipoReservaDiferenteDeAuto() throws Exception {
        ReservaDTOMapper reservaDTOMapper = new ReservaDTOMapper();
        EstabelecimentoDTOMapper estabelecimento = new EstabelecimentoDTOMapper();
        EstabelecimentoDTO estabelecimentoDTO = estabelecimento.estabelecimentoDTOMapperTipoReservaAvaliar();
        ReservaDTO reservaDTO = reservaDTOMapper.reservaDTOMapperStatusSolicitada();
        when(estabelecimentoClient.recuperarEstabelecimento(reservaDTO.getIdEstabelecimento()))
                .thenReturn(estabelecimentoDTO);
        when(reservaDBClient.inserirReserva(reservaDTO)).thenReturn(reservaDTO);
        ReservaDTO res = reservaDBClient.inserirReserva(reservaDTO);
        verify(reservaDBClient, times(1)).inserirReserva(reservaDTO);
        reservaSNSClient.notificarReservaEstabelecimento();
        verify(reservaSNSClient, times(1)).notificarReservaEstabelecimento();
        ReservaDTO result = reservarUseCase.execute(reservaDTO);
        Assert.assertEquals(StatusReservaEnum.SOLICITADA, result.getStatusReserva());

    }

}
