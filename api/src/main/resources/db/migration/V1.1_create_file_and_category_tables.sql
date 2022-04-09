CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
create table if not exists file(
    id uuid DEFAULT uuid_generate_v4() primary key,
    file_name varchar (55),
    file_path varchar (255),
    entity_id uuid not null,
    created_date timestamp default now(),
    last_update timestamp default now()
);
create table if not exists category(
    id uuid DEFAULT uuid_generate_v4() primary key,
    title varchar(255) not null,
    description varchar(1000),
    gender integer,
    parent_id    uuid,
    created_date timestamp default now(),
    last_update  timestamp default now(),
    CONSTRAINT fk_customer
        FOREIGN KEY (parent_id)
            REFERENCES category (id)
);