PGDMP                         w            tabajara    11.5 (Debian 11.5-3.pgdg90+1)    11.5 (Debian 11.5-3.pgdg90+1) X    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    16588    tabajara    DATABASE     z   CREATE DATABASE tabajara WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';
    DROP DATABASE tabajara;
             postgres    false            �            1255    25299    aft_delete_item()    FUNCTION     �   CREATE FUNCTION public.aft_delete_item() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	UPDATE compra SET total = (SELECT SUM(preco) FROM itens_compra WHERE id_compra = OLD.id_compra)
	WHERE id_compra = OLD.id_compra;
RETURN NEW;
END;

$$;
 (   DROP FUNCTION public.aft_delete_item();
       public       postgres    false            �            1255    25301    aft_delete_or_update_compra()    FUNCTION     �   CREATE FUNCTION public.aft_delete_or_update_compra() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	UPDATE conta SET total = (SELECT SUM(total) FROM compra WHERE id_conta = OLD.id_conta)
	WHERE id_conta = OLD.id_conta;
RETURN NEW;
END;

$$;
 4   DROP FUNCTION public.aft_delete_or_update_compra();
       public       postgres    false            �            1259    16592    cliente    TABLE     �   CREATE TABLE public.cliente (
    id_cliente integer NOT NULL,
    nome character varying,
    limite_de_credito double precision,
    tipo integer
);
    DROP TABLE public.cliente;
       public         postgres    false            �            1259    16619    pessoa_fisica    TABLE     a   CREATE TABLE public.pessoa_fisica (
    cpf character varying,
    id_fisica integer NOT NULL
);
 !   DROP TABLE public.pessoa_fisica;
       public         postgres    false            �            1259    16636    pessoa_juridica    TABLE     �   CREATE TABLE public.pessoa_juridica (
    cnpj character varying,
    nome_fantasia character varying,
    juridica_cliente integer
);
 #   DROP TABLE public.pessoa_juridica;
       public         postgres    false            �            1259    24956    busca_cliente    VIEW     �  CREATE VIEW public.busca_cliente AS
 SELECT cliente.id_cliente AS cod,
    cliente.nome,
    cliente.limite_de_credito AS credito,
    cliente.tipo,
    pessoa_fisica.cpf,
    pessoa_juridica.cnpj,
    pessoa_juridica.nome_fantasia
   FROM ((public.cliente
     JOIN public.pessoa_fisica ON ((cliente.id_cliente = pessoa_fisica.id_fisica)))
     JOIN public.pessoa_juridica ON ((cliente.id_cliente = pessoa_juridica.juridica_cliente)));
     DROP VIEW public.busca_cliente;
       public       postgres    false    197    201    201    202    202    202    197    197    197            �            1259    24964    cli    VIEW     �   CREATE VIEW public.cli AS
 SELECT cliente.id_cliente AS id,
    cliente.nome,
    cliente.limite_de_credito,
    cliente.tipo
   FROM public.cliente;
    DROP VIEW public.cli;
       public       postgres    false    197    197    197    197            �            1259    16590    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public       postgres    false    197            �           0    0    cliente_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id_cliente;
            public       postgres    false    196            �            1259    24960    fisica    VIEW     x   CREATE VIEW public.fisica AS
 SELECT pessoa_fisica.cpf,
    pessoa_fisica.id_fisica AS id
   FROM public.pessoa_fisica;
    DROP VIEW public.fisica;
       public       postgres    false    201    201            �            1259    24968    juridica    VIEW     �   CREATE VIEW public.juridica AS
 SELECT pessoa_juridica.cnpj,
    pessoa_juridica.nome_fantasia,
    pessoa_juridica.juridica_cliente AS id
   FROM public.pessoa_juridica;
    DROP VIEW public.juridica;
       public       postgres    false    202    202    202            �            1259    24972    clientes    VIEW        CREATE VIEW public.clientes AS
 SELECT cli.id AS cod,
    cli.nome,
    cli.limite_de_credito AS credito,
    cli.tipo,
    juridica.cnpj,
    juridica.nome_fantasia,
    fisica.cpf
   FROM ((public.cli
     LEFT JOIN public.juridica USING (id))
     LEFT JOIN public.fisica USING (id));
    DROP VIEW public.clientes;
       public       postgres    false    213    215    215    215    214    214    214    213    214            �            1259    25086    compra    TABLE     �   CREATE TABLE public.compra (
    id_compra integer NOT NULL,
    total double precision,
    data_compra date,
    id_conta integer
);
    DROP TABLE public.compra;
       public         postgres    false            �            1259    25117    compra_id_seq    SEQUENCE     v   CREATE SEQUENCE public.compra_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.compra_id_seq;
       public       postgres    false    218            �           0    0    compra_id_seq    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.compra_id_seq OWNED BY public.compra.id_compra;
            public       postgres    false    219            �            1259    16683    conta    TABLE     �   CREATE TABLE public.conta (
    id_conta integer NOT NULL,
    data_vencimento date,
    total double precision,
    id_cli integer
);
    DROP TABLE public.conta;
       public         postgres    false            �            1259    16681    conta_id_seq    SEQUENCE     �   CREATE SEQUENCE public.conta_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.conta_id_seq;
       public       postgres    false    206            �           0    0    conta_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.conta_id_seq OWNED BY public.conta.id_conta;
            public       postgres    false    205            �            1259    25329    contas    VIEW     V  CREATE VIEW public.contas AS
 SELECT conta.id_conta,
    conta.data_vencimento,
    conta.total,
    conta.id_cli,
    clientes.cod,
    clientes.nome,
    clientes.credito,
    clientes.tipo,
    clientes.cnpj,
    clientes.nome_fantasia,
    clientes.cpf
   FROM (public.conta
     JOIN public.clientes ON ((clientes.cod = conta.id_cli)));
    DROP VIEW public.contas;
       public       postgres    false    206    206    206    206    216    216    216    216    216    216    216            �            1259    16603    endereco    TABLE     9  CREATE TABLE public.endereco (
    id integer NOT NULL,
    end_idcliente integer NOT NULL,
    logradouro character varying,
    numero integer,
    complemento character varying,
    bairro character varying,
    municipio character varying,
    estado character varying,
    tipo_endereco character varying
);
    DROP TABLE public.endereco;
       public         postgres    false            �            1259    16601    endereco_id_seq    SEQUENCE     �   CREATE SEQUENCE public.endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.endereco_id_seq;
       public       postgres    false    199            �           0    0    endereco_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;
            public       postgres    false    198            �            1259    16696    fatura    TABLE     �   CREATE TABLE public.fatura (
    id_fatura integer NOT NULL,
    id_conta_fatura integer,
    data_quitacao date,
    quantidade_parcelas integer,
    juros double precision
);
    DROP TABLE public.fatura;
       public         postgres    false            �            1259    16694    fatura_id_seq    SEQUENCE     �   CREATE SEQUENCE public.fatura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.fatura_id_seq;
       public       postgres    false    208            �           0    0    fatura_id_seq    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.fatura_id_seq OWNED BY public.fatura.id_fatura;
            public       postgres    false    207            �            1259    25044    itens_compra    TABLE     �   CREATE TABLE public.itens_compra (
    id_item integer,
    id_prod integer,
    id_compra integer,
    preco double precision,
    id integer NOT NULL,
    cod_barras character varying
);
     DROP TABLE public.itens_compra;
       public         postgres    false            �            1259    25123    itens_id_seq    SEQUENCE     u   CREATE SEQUENCE public.itens_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.itens_id_seq;
       public       postgres    false    217            �           0    0    itens_id_seq    SEQUENCE OWNED BY     D   ALTER SEQUENCE public.itens_id_seq OWNED BY public.itens_compra.id;
            public       postgres    false    220            �            1259    24907    login    TABLE     l   CREATE TABLE public.login (
    usuario character varying NOT NULL,
    senha character varying NOT NULL
);
    DROP TABLE public.login;
       public         postgres    false            �            1259    16704 	   pagamento    TABLE     �   CREATE TABLE public.pagamento (
    id integer NOT NULL,
    data_vencimento date,
    valor double precision,
    tipo integer,
    juros double precision,
    id_fatura integer,
    paga boolean DEFAULT false NOT NULL,
    data_pagamento date
);
    DROP TABLE public.pagamento;
       public         postgres    false            �            1259    16702    pagamento_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pagamento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.pagamento_id_seq;
       public       postgres    false    210            �           0    0    pagamento_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.pagamento_id_seq OWNED BY public.pagamento.id;
            public       postgres    false    209            �            1259    16617    pessoa_fisica_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pessoa_fisica_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.pessoa_fisica_id_seq;
       public       postgres    false    201            �           0    0    pessoa_fisica_id_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE public.pessoa_fisica_id_seq OWNED BY public.pessoa_fisica.id_fisica;
            public       postgres    false    200            �            1259    16654    produto    TABLE        CREATE TABLE public.produto (
    id_produto integer NOT NULL,
    nome character varying,
    preco double precision,
    cod_barras character varying,
    tipo_de_uva character varying,
    pais_de_origem character varying,
    tipo_de_vinho character varying,
    id_compra integer
);
    DROP TABLE public.produto;
       public         postgres    false            �            1259    16652    produto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.produto_id_seq;
       public       postgres    false    204            �           0    0    produto_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id_produto;
            public       postgres    false    203                       2604    16595    cliente id_cliente    DEFAULT     p   ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN id_cliente DROP DEFAULT;
       public       postgres    false    196    197    197                       2604    25119    compra id_compra    DEFAULT     m   ALTER TABLE ONLY public.compra ALTER COLUMN id_compra SET DEFAULT nextval('public.compra_id_seq'::regclass);
 ?   ALTER TABLE public.compra ALTER COLUMN id_compra DROP DEFAULT;
       public       postgres    false    219    218                       2604    16686    conta id_conta    DEFAULT     j   ALTER TABLE ONLY public.conta ALTER COLUMN id_conta SET DEFAULT nextval('public.conta_id_seq'::regclass);
 =   ALTER TABLE public.conta ALTER COLUMN id_conta DROP DEFAULT;
       public       postgres    false    206    205    206                       2604    16606    endereco id    DEFAULT     j   ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);
 :   ALTER TABLE public.endereco ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198    199                       2604    16699    fatura id_fatura    DEFAULT     m   ALTER TABLE ONLY public.fatura ALTER COLUMN id_fatura SET DEFAULT nextval('public.fatura_id_seq'::regclass);
 ?   ALTER TABLE public.fatura ALTER COLUMN id_fatura DROP DEFAULT;
       public       postgres    false    208    207    208                       2604    25125    itens_compra id    DEFAULT     k   ALTER TABLE ONLY public.itens_compra ALTER COLUMN id SET DEFAULT nextval('public.itens_id_seq'::regclass);
 >   ALTER TABLE public.itens_compra ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    220    217                       2604    16707    pagamento id    DEFAULT     l   ALTER TABLE ONLY public.pagamento ALTER COLUMN id SET DEFAULT nextval('public.pagamento_id_seq'::regclass);
 ;   ALTER TABLE public.pagamento ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    210    209    210                       2604    16622    pessoa_fisica id_fisica    DEFAULT     {   ALTER TABLE ONLY public.pessoa_fisica ALTER COLUMN id_fisica SET DEFAULT nextval('public.pessoa_fisica_id_seq'::regclass);
 F   ALTER TABLE public.pessoa_fisica ALTER COLUMN id_fisica DROP DEFAULT;
       public       postgres    false    200    201    201                       2604    16657    produto id_produto    DEFAULT     p   ALTER TABLE ONLY public.produto ALTER COLUMN id_produto SET DEFAULT nextval('public.produto_id_seq'::regclass);
 A   ALTER TABLE public.produto ALTER COLUMN id_produto DROP DEFAULT;
       public       postgres    false    204    203    204            �          0    16592    cliente 
   TABLE DATA               L   COPY public.cliente (id_cliente, nome, limite_de_credito, tipo) FROM stdin;
    public       postgres    false    197   Kf       �          0    25086    compra 
   TABLE DATA               I   COPY public.compra (id_compra, total, data_compra, id_conta) FROM stdin;
    public       postgres    false    218   �f       �          0    16683    conta 
   TABLE DATA               I   COPY public.conta (id_conta, data_vencimento, total, id_cli) FROM stdin;
    public       postgres    false    206   �g       �          0    16603    endereco 
   TABLE DATA               �   COPY public.endereco (id, end_idcliente, logradouro, numero, complemento, bairro, municipio, estado, tipo_endereco) FROM stdin;
    public       postgres    false    199   h       �          0    16696    fatura 
   TABLE DATA               g   COPY public.fatura (id_fatura, id_conta_fatura, data_quitacao, quantidade_parcelas, juros) FROM stdin;
    public       postgres    false    208   �i       �          0    25044    itens_compra 
   TABLE DATA               Z   COPY public.itens_compra (id_item, id_prod, id_compra, preco, id, cod_barras) FROM stdin;
    public       postgres    false    217    j       �          0    24907    login 
   TABLE DATA               /   COPY public.login (usuario, senha) FROM stdin;
    public       postgres    false    211   �j       �          0    16704 	   pagamento 
   TABLE DATA               m   COPY public.pagamento (id, data_vencimento, valor, tipo, juros, id_fatura, paga, data_pagamento) FROM stdin;
    public       postgres    false    210   k       �          0    16619    pessoa_fisica 
   TABLE DATA               7   COPY public.pessoa_fisica (cpf, id_fisica) FROM stdin;
    public       postgres    false    201   >l       �          0    16636    pessoa_juridica 
   TABLE DATA               P   COPY public.pessoa_juridica (cnpj, nome_fantasia, juridica_cliente) FROM stdin;
    public       postgres    false    202   zl       �          0    16654    produto 
   TABLE DATA               }   COPY public.produto (id_produto, nome, preco, cod_barras, tipo_de_uva, pais_de_origem, tipo_de_vinho, id_compra) FROM stdin;
    public       postgres    false    204   �l       �           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 28, true);
            public       postgres    false    196            �           0    0    compra_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.compra_id_seq', 57, true);
            public       postgres    false    219            �           0    0    conta_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.conta_id_seq', 48, true);
            public       postgres    false    205            �           0    0    endereco_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.endereco_id_seq', 40, true);
            public       postgres    false    198            �           0    0    fatura_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.fatura_id_seq', 10, true);
            public       postgres    false    207            �           0    0    itens_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.itens_id_seq', 97, true);
            public       postgres    false    220            �           0    0    pagamento_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.pagamento_id_seq', 83, true);
            public       postgres    false    209            �           0    0    pessoa_fisica_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.pessoa_fisica_id_seq', 1, false);
            public       postgres    false    200            �           0    0    produto_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.produto_id_seq', 6, true);
            public       postgres    false    203                       2606    16597    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public         postgres    false    197            (           2606    25090    compra compra_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_pkey PRIMARY KEY (id_compra);
 <   ALTER TABLE ONLY public.compra DROP CONSTRAINT compra_pkey;
       public         postgres    false    218                       2606    16688    conta conta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.conta
    ADD CONSTRAINT conta_pkey PRIMARY KEY (id_conta);
 :   ALTER TABLE ONLY public.conta DROP CONSTRAINT conta_pkey;
       public         postgres    false    206                       2606    16611    endereco endereco_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public         postgres    false    199                        2606    16701    fatura fatura_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.fatura
    ADD CONSTRAINT fatura_pkey PRIMARY KEY (id_fatura);
 <   ALTER TABLE ONLY public.fatura DROP CONSTRAINT fatura_pkey;
       public         postgres    false    208            &           2606    25097    itens_compra itenss_compra_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.itens_compra
    ADD CONSTRAINT itenss_compra_pkey PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.itens_compra DROP CONSTRAINT itenss_compra_pkey;
       public         postgres    false    217            $           2606    24914    login login_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (usuario);
 :   ALTER TABLE ONLY public.login DROP CONSTRAINT login_pkey;
       public         postgres    false    211            "           2606    16709    pagamento pagamento_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.pagamento DROP CONSTRAINT pagamento_pkey;
       public         postgres    false    210                       2606    16662    produto produto_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    204            0           2620    25300     itens_compra update_total_compra    TRIGGER     �   CREATE TRIGGER update_total_compra AFTER DELETE ON public.itens_compra FOR EACH ROW EXECUTE PROCEDURE public.aft_delete_item();
 9   DROP TRIGGER update_total_compra ON public.itens_compra;
       public       postgres    false    217    222            1           2620    25302    compra update_total_conta    TRIGGER     �   CREATE TRIGGER update_total_conta AFTER DELETE OR UPDATE ON public.compra FOR EACH ROW EXECUTE PROCEDURE public.aft_delete_or_update_compra();
 2   DROP TRIGGER update_total_conta ON public.compra;
       public       postgres    false    218    223            +           2606    16647    pessoa_juridica fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoa_juridica
    ADD CONSTRAINT fk FOREIGN KEY (juridica_cliente) REFERENCES public.cliente(id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.pessoa_juridica DROP CONSTRAINT fk;
       public       postgres    false    2840    197    202            -           2606    25047    itens_compra fk1    FK CONSTRAINT     �   ALTER TABLE ONLY public.itens_compra
    ADD CONSTRAINT fk1 FOREIGN KEY (id_prod) REFERENCES public.produto(id_produto) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.itens_compra DROP CONSTRAINT fk1;
       public       postgres    false    204    2844    217            .           2606    25098    itens_compra fk2    FK CONSTRAINT     �   ALTER TABLE ONLY public.itens_compra
    ADD CONSTRAINT fk2 FOREIGN KEY (id_compra) REFERENCES public.compra(id_compra) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 :   ALTER TABLE ONLY public.itens_compra DROP CONSTRAINT fk2;
       public       postgres    false    2856    218    217            /           2606    25091    compra fk_comp    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT fk_comp FOREIGN KEY (id_conta) REFERENCES public.conta(id_conta) ON UPDATE CASCADE ON DELETE CASCADE;
 8   ALTER TABLE ONLY public.compra DROP CONSTRAINT fk_comp;
       public       postgres    false    206    2846    218            ,           2606    16710    pagamento fk_fatura    FK CONSTRAINT     �   ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT fk_fatura FOREIGN KEY (id_fatura) REFERENCES public.fatura(id_fatura) ON UPDATE CASCADE ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.pagamento DROP CONSTRAINT fk_fatura;
       public       postgres    false    2848    210    208            )           2606    16612    endereco id_end    FK CONSTRAINT     �   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT id_end FOREIGN KEY (end_idcliente) REFERENCES public.cliente(id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;
 9   ALTER TABLE ONLY public.endereco DROP CONSTRAINT id_end;
       public       postgres    false    2840    199    197            *           2606    16631    pessoa_fisica pk_in    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoa_fisica
    ADD CONSTRAINT pk_in FOREIGN KEY (id_fisica) REFERENCES public.cliente(id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.pessoa_fisica DROP CONSTRAINT pk_in;
       public       postgres    false    201    2840    197            �   �   x�=�A�0D��SpE
.��LH�n�|i��OZ�B��I1q3��&��hh��E��)2!%<?���ކ�jR�=޼�_��`(�v%(�lC^sra�cS�e%���Im=9M�
�*�n
#'5uԿ�ل�mS�4��\�<����ȋ��c'���/6      �   |   x�m��1�d/YH壉T���X ���@�L44C1/���1:"&G�P�1��P�S:`���1�`��ܙ���}@I�)p�7fL�����ye����\���1��p&����q�+��Ӕ7�      �   l   x�U���0��.DI��%:A�������p�1LY������N�|�:R�����S��o���}��sy�e,P�3�M��ZL�<p}V{�����c���f!�:D���#g      �   �  x����n�0��O�-S��y4d7H�4�ݱ�Ibi���m�N:�o��I���Kp���>RϠ��d�t��"��q]�p�`d�O�[
��^���KОBG-Wy�r$P��L)�O)������k�b�
�@)$)R�8Ź ZC�:ŕ��s�ӫ;(��Ps�S�oj�S�����?p�aÃ�S��<�2P�����`K<M�+Ki�{$��~�l��t̰�mm\eI��5�ӑ��4�ƺ�;2�z�W�����f�·&T��C]N��dA����bx����+^�iE놗�o,��o����6���og����#���g�7TQK�'�HVV��'��;��:�^F���?泣�*���+B�r�}��kv=O��c��l�LpԖ}5N{��r��_�!� �V�l      �   `   x�]��	1�v/��$v/���;�9��$��0ҐB?Nܴn�:��
�$�?e�50�*#�%�z���o�+!Y?n�G+_��h}��~  h�      �   �   x�M��� �3�����������l�o����o�.1��^��Z2�Dѷd�(1BԄ
hg�
P�qƆ����!
�l�	��l�`�c�'6 ������Y�(���z��� p� ���5���1�#������r$/��b��	��n����L�-~d5a��/��J)�K      �   2   x�KL����42426J3�4O4�DscK�D�T�Dôdc�=... 4
�      �     x�u�ˑ� �3��.	�>Ils��CX�:lsr��eP������$if�5k���9t��:��'Gc���e�hqc���3½`˿��̰2���k鹱Qn�F�KF����t,��G�O�a+X6��`�T ���Ta��cu���5�� ��S��pi�\!8Rr�k��� l��`/X��hL�h�V#]����jn#.�)�K�gN���ڔ�
j�r$�f���`)xd. k�^'dtBn�Wwv���S�3�����R:�����`0�      �   ,   x���   �77�	�Dwq�9lm�+!ʢ��q�R��rx���U      �   L   x�34�L��,.��S(����/�42�45���,J�KIT���sq'���+$�祥&^~xk*PƐ+F��� i2      �   f   x�5�K
� F���*Z� ��E+prI!�p3�>3��cA"|�N0fBI�06�3�,�[���S	V�p����ïjpFM92Ʈf\��6�Cn���;tZ)� �0#�     