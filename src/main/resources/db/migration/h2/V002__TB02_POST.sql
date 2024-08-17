CREATE TABLE public.tb02_post (
    postid bigint generated by default as identity,
    titulo varchar(100) NOT NULL,
    texto varchar(1000) NOT NULL,
    data_cadastro timestamp NOT NULL,
    CONSTRAINT tb02_postid_pk PRIMARY KEY (postid)
);
