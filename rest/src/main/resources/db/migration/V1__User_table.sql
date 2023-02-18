CREATE TABLE users (
  id BIGSERIAL NOT NULL,
  created_by VARCHAR(255),
  created_date TIMESTAMP(6),
  last_modified_by VARCHAR(255),
  last_modified_date VARCHAR(6),
  email VARCHAR(100) NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  password VARCHAR(255) NOT NULL,
  roles VARCHAR(255) NOT NULL,
  user_name VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
);