resource "aws_dynamodb_table" "estabelecimento" {
  name         = "he-estabelecimento"
  billing_mode = "PAY_PER_REQUEST"
  hash_key     = "id"

  attribute {
    name = "id"
    type = "S"
  }

  tags = {
    Environment = var.env
    Project     = var.project_name
  }
}

resource "aws_dynamodb_table" "usuario" {
  name         = "he-usuario"
  billing_mode = "PAY_PER_REQUEST"
  hash_key     = "id"
  attribute {
    name = "id"
    type = "S"
  }

  attribute {
    name = "email"
    type = "S"
  }

  global_secondary_index {
    name            = "gsi_email"
    hash_key        = "email"
    projection_type = "ALL"

  }
}

resource "aws_dynamodb_table" "reserva" {
  name         = "he-reserva"
  billing_mode = "PAY_PER_REQUEST"
  hash_key     = "idReserva"
  attribute {
    name = "idReserva"
    type = "S"
  }

  attribute {
    name = "idUsuario"
    type = "S"
  }

  attribute {
    name = "idEstabelecimento"
    type = "S"
  }

  global_secondary_index {
    name            = "gsi_usuario"
    hash_key        = "idUsuario"
    projection_type = "ALL"

  }

  global_secondary_index {
    name            = "gsi_estabelecimento"
    hash_key        = "idEstabelecimento"
    projection_type = "ALL"

  }
}