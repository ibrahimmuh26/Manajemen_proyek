use sei_spring;

create  table lokasi (
    id int not null AUTO_INCREMENT,
    nama_lokasi varchar(255) not null ,
    negara varchar(100) not null,
    provinsi varchar(100) not null,
    kota varchar(100) not null ,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key (id),
    unique (nama_lokasi)
) engine InnoDb;

select * from lokasi;



create table proyek (
    id int not null AUTO_INCREMENT,
    nama_proyek varchar(255) not null,
    client varchar(255) not null ,
    tgl_mulai datetime not null ,
    tgl_selesai datetime not null ,
    pimpinan_proyek varchar(255) not null ,
    keterangan text,
    primary key (id)

) engine InnoDb;

create table proyek_lokasi (
    id int not null AUTO_INCREMENT,
    proyek_id int null ,
    lokasi_id int null,
    primary key (id)
) engine  InnoDb;