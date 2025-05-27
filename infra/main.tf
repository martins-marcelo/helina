### S3 ###
resource "aws_s3_bucket" "bucket" {
  bucket = "${var.project_name}-profile-picture-${var.env}"

  tags = {
    Environment = var.env
    Project     = var.project_name
  }
}

### SNS ###
resource "aws_sns_topic" "notifica_reserva" {
  name = "notifica-reserva-${var.env}"

  tags = {
    Environment = var.env
    Project     = var.project_name
  }
}

### IAM ###
data "aws_iam_policy_document" "policy" {
  statement {
    actions = [
      "dynamodb:*",
      "s3:*",
      "sns:*",
      "secretsmanager:GetSecretValue"
    ]
    resources = ["*"]
  }
}

resource "aws_iam_user" "app_user" {
  name = "${var.project_name}-user-${var.env}"
}

resource "aws_iam_user_policy" "policy" {
  name   = "${var.project_name}-policy-${var.env}"
  user   = aws_iam_user.app_user.name
  policy = data.aws_iam_policy_document.policy.json
}

resource "aws_iam_access_key" "app_access_key" {
  user = aws_iam_user.app_user.name
}

