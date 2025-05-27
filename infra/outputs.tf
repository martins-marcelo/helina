output "dynamodb_estabelecimento" {
  value = aws_dynamodb_table.estabelecimento.name
}

output "dynamodb_usuario" {
  value = aws_dynamodb_table.usuario.name
}

output "dynamodb_reserva" {
  value = aws_dynamodb_table.reserva.name
}

output "s3_bucket" {
  value = aws_s3_bucket.bucket.bucket
}

output "sns_topic_arn" {
  value = aws_sns_topic.notifica_reserva.arn
}
