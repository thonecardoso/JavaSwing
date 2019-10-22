-- Table: public.cliente

-- DROP TABLE public.cliente;

CREATE TABLE public.cliente
(
    id_cliente integer NOT NULL DEFAULT nextval('cliente_id_seq'::regclass),
    nome character varying COLLATE pg_catalog."default",
    limite_de_credito double precision,
    tipo integer,
    CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cliente
    OWNER to postgres;

-- Table: public.compra

-- DROP TABLE public.compra;

CREATE TABLE public.compra
(
    id_compra integer NOT NULL DEFAULT nextval('compra_id_seq'::regclass),
    total double precision,
    data_compra timestamp without time zone,
    id_conta integer,
    CONSTRAINT compra_pkey PRIMARY KEY (id_compra),
    CONSTRAINT fk_conta FOREIGN KEY (id_conta)
        REFERENCES public.conta (id_conta) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.compra
    OWNER to postgres;

-- Table: public.conta

-- DROP TABLE public.conta;

CREATE TABLE public.conta
(
    id_conta integer NOT NULL DEFAULT nextval('conta_id_seq'::regclass),
    data_vencimento timestamp without time zone,
    total double precision,
    id_cli integer,
    CONSTRAINT conta_pkey PRIMARY KEY (id_conta)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.conta
    OWNER to postgres;

-- Table: public.endereco

-- DROP TABLE public.endereco;

CREATE TABLE public.endereco
(
    id integer NOT NULL DEFAULT nextval('endereco_id_seq'::regclass),
    end_idcliente integer NOT NULL,
    logradouro character varying COLLATE pg_catalog."default",
    numero integer,
    complemento character varying COLLATE pg_catalog."default",
    bairro character varying COLLATE pg_catalog."default",
    municipio character varying COLLATE pg_catalog."default",
    estado character varying COLLATE pg_catalog."default",
    tipo_endereco character varying COLLATE pg_catalog."default",
    CONSTRAINT endereco_pkey PRIMARY KEY (id),
    CONSTRAINT id_end FOREIGN KEY (end_idcliente)
        REFERENCES public.cliente (id_cliente) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.endereco
    OWNER to postgres;

-- Table: public.fatura

-- DROP TABLE public.fatura;

CREATE TABLE public.fatura
(
    id_fatura integer NOT NULL DEFAULT nextval('fatura_id_seq'::regclass),
    id_conta_fatura integer,
    data_quitacao timestamp without time zone,
    quantidade_parcelas integer,
    juros double precision,
    CONSTRAINT fatura_pkey PRIMARY KEY (id_fatura)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.fatura
    OWNER to postgres;

-- Table: public.login

-- DROP TABLE public.login;

CREATE TABLE public.login
(
    usuario character varying COLLATE pg_catalog."default" NOT NULL,
    senha character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT login_pkey PRIMARY KEY (usuario)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.login
    OWNER to postgres;

-- Table: public.pagamento

-- DROP TABLE public.pagamento;

CREATE TABLE public.pagamento
(
    id integer NOT NULL DEFAULT nextval('pagamento_id_seq'::regclass),
    data timestamp without time zone,
    valor double precision,
    tipo integer,
    juros double precision,
    id_fatura integer,
    CONSTRAINT pagamento_pkey PRIMARY KEY (id),
    CONSTRAINT fk_fatura FOREIGN KEY (id_fatura)
        REFERENCES public.fatura (id_fatura) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pagamento
    OWNER to postgres;

-- Table: public.pessoa_fisica

-- DROP TABLE public.pessoa_fisica;

CREATE TABLE public.pessoa_fisica
(
    cpf character varying COLLATE pg_catalog."default",
    id_fisica integer NOT NULL DEFAULT nextval('pessoa_fisica_id_seq'::regclass),
    CONSTRAINT pk_in FOREIGN KEY (id_fisica)
        REFERENCES public.cliente (id_cliente) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pessoa_fisica
    OWNER to postgres;

-- Table: public.pessoa_juridica

-- DROP TABLE public.pessoa_juridica;

CREATE TABLE public.pessoa_juridica
(
    cnpj character varying COLLATE pg_catalog."default",
    nome_fantasia character varying COLLATE pg_catalog."default",
    juridica_cliente integer,
    CONSTRAINT fk FOREIGN KEY (juridica_cliente)
        REFERENCES public.cliente (id_cliente) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pessoa_juridica
    OWNER to postgres;

-- Table: public.produto

-- DROP TABLE public.produto;

CREATE TABLE public.produto
(
    id_produto integer NOT NULL DEFAULT nextval('produto_id_seq'::regclass),
    nome character varying COLLATE pg_catalog."default",
    preco double precision,
    cod_barras character varying COLLATE pg_catalog."default",
    tipo_de_uva character varying COLLATE pg_catalog."default",
    pais_de_origem character varying COLLATE pg_catalog."default",
    tipo_de_vinho character varying COLLATE pg_catalog."default",
    id_compra integer,
    CONSTRAINT produto_pkey PRIMARY KEY (id_produto),
    CONSTRAINT fk_compra FOREIGN KEY (id_compra)
        REFERENCES public.compra (id_compra) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.produto
    OWNER to postgres;
