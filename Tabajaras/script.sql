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
    data_compra date,
    id_conta integer,
    CONSTRAINT compra_pkey PRIMARY KEY (id_compra),
    CONSTRAINT fk_comp FOREIGN KEY (id_conta)
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
    data_vencimento date,
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

-- Table: public.itens_compra

-- DROP TABLE public.itens_compra;

CREATE TABLE public.itens_compra
(
    id_item integer,
    id_prod integer,
    id_compra integer,
    preco double precision,
    id integer NOT NULL DEFAULT nextval('itens_id_seq'::regclass),
    cod_barras character varying COLLATE pg_catalog."default",
    CONSTRAINT itenss_compra_pkey PRIMARY KEY (id),
    CONSTRAINT fk1 FOREIGN KEY (id_prod)
        REFERENCES public.produto (id_produto) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT fk2 FOREIGN KEY (id_compra)
        REFERENCES public.compra (id_compra) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.itens_compra
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
    CONSTRAINT produto_pkey PRIMARY KEY (id_produto)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.produto
    OWNER to postgres;

-- View: public.busca_cliente

-- DROP VIEW public.busca_cliente;

CREATE OR REPLACE VIEW public.busca_cliente
 AS
 SELECT cliente.id_cliente AS cod,
    cliente.nome,
    cliente.limite_de_credito AS credito,
    cliente.tipo,
    pessoa_fisica.cpf,
    pessoa_juridica.cnpj,
    pessoa_juridica.nome_fantasia
   FROM cliente
     JOIN pessoa_fisica ON cliente.id_cliente = pessoa_fisica.id_fisica
     JOIN pessoa_juridica ON cliente.id_cliente = pessoa_juridica.juridica_cliente;

ALTER TABLE public.busca_cliente
    OWNER TO postgres;

-- View: public.cli

-- DROP VIEW public.cli;

CREATE OR REPLACE VIEW public.cli
 AS
 SELECT cliente.id_cliente AS id,
    cliente.nome,
    cliente.limite_de_credito,
    cliente.tipo
   FROM cliente;

ALTER TABLE public.cli
    OWNER TO postgres;

-- View: public.clientes

-- DROP VIEW public.clientes;

CREATE OR REPLACE VIEW public.clientes
 AS
 SELECT cli.id AS cod,
    cli.nome,
    cli.limite_de_credito AS credito,
    cli.tipo,
    juridica.cnpj,
    juridica.nome_fantasia,
    fisica.cpf
   FROM cli
     LEFT JOIN juridica USING (id)
     LEFT JOIN fisica USING (id);

ALTER TABLE public.clientes
    OWNER TO postgres;

-- View: public.fisica

-- DROP VIEW public.fisica;

CREATE OR REPLACE VIEW public.fisica
 AS
 SELECT pessoa_fisica.cpf,
    pessoa_fisica.id_fisica AS id
   FROM pessoa_fisica;

ALTER TABLE public.fisica
    OWNER TO postgres;

-- View: public.juridica

-- DROP VIEW public.juridica;

CREATE OR REPLACE VIEW public.juridica
 AS
 SELECT pessoa_juridica.cnpj,
    pessoa_juridica.nome_fantasia,
    pessoa_juridica.juridica_cliente AS id
   FROM pessoa_juridica;

ALTER TABLE public.juridica
    OWNER TO postgres;


