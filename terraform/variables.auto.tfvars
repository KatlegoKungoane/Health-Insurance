mandatory_tags = {
  owner         = "alexander.kruger@bbd.co.za"
  created-using = "terraform"
}

account_number = "574836245203"

certificate = "51456bea-3d96-4f9d-a893-904c29d58afe" //

repo = "BBD-Health-Insurance/Health-Insurance"

region = "eu-west-1"

project_name = "health-insurance"

vpc_public_subnets = [
  {
    cidr_block = "15.0.1.0/24"
    az         = "eu-west-1a"
  },
  {
    cidr_block = "15.0.3.0/24"
    az         = "eu-west-1b"
}]

vpc_private_subnets = [
  {
    cidr_block = "15.0.5.0/24"
    az         = "eu-west-1a"
  },
  {
    cidr_block = "15.0.7.0/24"
    az         = "eu-west-1b"
}]

db_port = 1433

eb_port_web = 80


