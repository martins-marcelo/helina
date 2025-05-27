variable "env" {
  description = "Ambiente (dev, staging, prod)"
  type        = string
  default     = "prod"
}

variable "project_name" {
  description = "Nome do projeto"
  type        = string
  default     = "helina"
}