PGDMP     *                
    w            tabajara    11.5 (Debian 11.5-3.pgdg90+1)    11.5 (Debian 11.5-3.pgdg90+1) U    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    16588    tabajara    DATABASE     z   CREATE DATABASE tabajara WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8';
    DROP DATABASE tabajara;
             postgres    false            �            1259    16592    cliente    TABLE     �   CREATE TABLE public.cliente (
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
       public       postgres    false    197    197    197    197    201    201    202    202    202            �            1259    24964    cli    VIEW     �   CREATE VIEW public.cli AS
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
       public       postgres    false    214    215    213    214    215    214    214    215    213            �            1259    25086    compra    TABLE     �   CREATE TABLE public.compra (
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
       public       postgres    false    219            �           0    0    compra_id_seq    SEQUENCE OWNED BY     F   ALTER SEQUENCE public.compra_id_seq OWNED BY public.compra.id_compra;
            public       postgres    false    220            �            1259    16683    conta    TABLE     �   CREATE TABLE public.conta (
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
            public       postgres    false    205            �            1259    16603    endereco    TABLE     9  CREATE TABLE public.endereco (
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
    data_quitacao timestamp without time zone,
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
       public       postgres    false    218            �           0    0    itens_id_seq    SEQUENCE OWNED BY     D   ALTER SEQUENCE public.itens_id_seq OWNED BY public.itens_compra.id;
            public       postgres    false    221            �            1259    24907    login    TABLE     l   CREATE TABLE public.login (
    usuario character varying NOT NULL,
    senha character varying NOT NULL
);
    DROP TABLE public.login;
       public         postgres    false            �            1259    16704 	   pagamento    TABLE     �   CREATE TABLE public.pagamento (
    id integer NOT NULL,
    data timestamp without time zone,
    valor double precision,
    tipo integer,
    juros double precision,
    id_fatura integer
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
            public       postgres    false    203            �            1259    24992    teste    TABLE     R   CREATE TABLE public.teste (
    asdf date,
    asd timestamp without time zone
);
    DROP TABLE public.teste;
       public         postgres    false                       2604    16595    cliente id_cliente    DEFAULT     p   ALTER TABLE ONLY public.cliente ALTER COLUMN id_cliente SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 A   ALTER TABLE public.cliente ALTER COLUMN id_cliente DROP DEFAULT;
       public       postgres    false    196    197    197                       2604    25119    compra id_compra    DEFAULT     m   ALTER TABLE ONLY public.compra ALTER COLUMN id_compra SET DEFAULT nextval('public.compra_id_seq'::regclass);
 ?   ALTER TABLE public.compra ALTER COLUMN id_compra DROP DEFAULT;
       public       postgres    false    220    219                       2604    16686    conta id_conta    DEFAULT     j   ALTER TABLE ONLY public.conta ALTER COLUMN id_conta SET DEFAULT nextval('public.conta_id_seq'::regclass);
 =   ALTER TABLE public.conta ALTER COLUMN id_conta DROP DEFAULT;
       public       postgres    false    205    206    206                       2604    16606    endereco id    DEFAULT     j   ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);
 :   ALTER TABLE public.endereco ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198    199                       2604    16699    fatura id_fatura    DEFAULT     m   ALTER TABLE ONLY public.fatura ALTER COLUMN id_fatura SET DEFAULT nextval('public.fatura_id_seq'::regclass);
 ?   ALTER TABLE public.fatura ALTER COLUMN id_fatura DROP DEFAULT;
       public       postgres    false    207    208    208                       2604    25125    itens_compra id    DEFAULT     k   ALTER TABLE ONLY public.itens_compra ALTER COLUMN id SET DEFAULT nextval('public.itens_id_seq'::regclass);
 >   ALTER TABLE public.itens_compra ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    221    218                       2604    16707    pagamento id    DEFAULT     l   ALTER TABLE ONLY public.pagamento ALTER COLUMN id SET DEFAULT nextval('public.pagamento_id_seq'::regclass);
 ;   ALTER TABLE public.pagamento ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    209    210    210                       2604    16622    pessoa_fisica id_fisica    DEFAULT     {   ALTER TABLE ONLY public.pessoa_fisica ALTER COLUMN id_fisica SET DEFAULT nextval('public.pessoa_fisica_id_seq'::regclass);
 F   ALTER TABLE public.pessoa_fisica ALTER COLUMN id_fisica DROP DEFAULT;
       public       postgres    false    201    200    201                       2604    16657    produto id_produto    DEFAULT     p   ALTER TABLE ONLY public.produto ALTER COLUMN id_produto SET DEFAULT nextval('public.produto_id_seq'::regclass);
 A   ALTER TABLE public.produto ALTER COLUMN id_produto DROP DEFAULT;
       public       postgres    false    203    204    204            �          0    16592    cliente 
   TABLE DATA               L   COPY public.cliente (id_cliente, nome, limite_de_credito, tipo) FROM stdin;
    public       postgres    false    197   3_       �          0    25086    compra 
   TABLE DATA               I   COPY public.compra (id_compra, total, data_compra, id_conta) FROM stdin;
    public       postgres    false    219   �_       �          0    16683    conta 
   TABLE DATA               I   COPY public.conta (id_conta, data_vencimento, total, id_cli) FROM stdin;
    public       postgres    false    206   S`       �          0    16603    endereco 
   TABLE DATA               �   COPY public.endereco (id, end_idcliente, logradouro, numero, complemento, bairro, municipio, estado, tipo_endereco) FROM stdin;
    public       postgres    false    199   a       �          0    16696    fatura 
   TABLE DATA               g   COPY public.fatura (id_fatura, id_conta_fatura, data_quitacao, quantidade_parcelas, juros) FROM stdin;
    public       postgres    false    208   �a       �          0    25044    itens_compra 
   TABLE DATA               Z   COPY public.itens_compra (id_item, id_prod, id_compra, preco, id, cod_barras) FROM stdin;
    public       postgres    false    218   �a       �          0    24907    login 
   TABLE DATA               /   COPY public.login (usuario, senha) FROM stdin;
    public       postgres    false    211   Eb       �          0    16704 	   pagamento 
   TABLE DATA               L   COPY public.pagamento (id, data, valor, tipo, juros, id_fatura) FROM stdin;
    public       postgres    false    210   �b       �          0    16619    pessoa_fisica 
   TABLE DATA               7   COPY public.pessoa_fisica (cpf, id_fisica) FROM stdin;
    public       postgres    false    201   �b       �          0    16636    pessoa_juridica 
   TABLE DATA               P   COPY public.pessoa_juridica (cnpj, nome_fantasia, juridica_cliente) FROM stdin;
    public       postgres    false    202   �b       �          0    16654    produto 
   TABLE DATA               }   COPY public.produto (id_produto, nome, preco, cod_barras, tipo_de_uva, pais_de_origem, tipo_de_vinho, id_compra) FROM stdin;
    public       postgres    false    204   c       �          0    24992    teste 
   TABLE DATA               *   COPY public.teste (asdf, asd) FROM stdin;
    public       postgres    false    217   bc       �           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 22, true);
            public       postgres    false    196            �           0    0    compra_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.compra_id_seq', 42, true);
            public       postgres    false    220            �           0    0    conta_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.conta_id_seq', 39, true);
            public       postgres    false    205            �           0    0    endereco_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.endereco_id_seq', 31, true);
            public       postgres    false    198            �           0    0    fatura_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.fatura_id_seq', 1, false);
            public       postgres    false    207            �           0    0    itens_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.itens_id_seq', 69, true);
            public       postgres    false    221            �           0    0    pagamento_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.pagamento_id_seq', 1, false);
            public       postgres    false    209            �           0    0    pessoa_fisica_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.pessoa_fisica_id_seq', 1, false);
            public       postgres    false    200            �           0    0    produto_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.produto_id_seq', 4, true);
            public       postgres    false    203                       2606    16597    cliente cliente_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public         postgres    false    197            %           2606    25090    compra compra_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_pkey PRIMARY KEY (id_compra);
 <   ALTER TABLE ONLY public.compra DROP CONSTRAINT compra_pkey;
       public         postgres    false    219                       2606    16688    conta conta_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.conta
    ADD CONSTRAINT conta_pkey PRIMARY KEY (id_conta);
 :   ALTER TABLE ONLY public.conta DROP CONSTRAINT conta_pkey;
       public         postgres    false    206                       2606    16611    endereco endereco_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.endereco DROP CONSTRAINT endereco_pkey;
       public         postgres    false    199                       2606    16701    fatura fatura_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.fatura
    ADD CONSTRAINT fatura_pkey PRIMARY KEY (id_fatura);
 <   ALTER TABLE ONLY public.fatura DROP CONSTRAINT fatura_pkey;
       public         postgres    false    208            #           2606    25097    itens_compra itenss_compra_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.itens_compra
    ADD CONSTRAINT itenss_compra_pkey PRIMARY KEY (id);
 I   ALTER TABLE ONLY public.itens_compra DROP CONSTRAINT itenss_compra_pkey;
       public         postgres    false    218            !           2606    24914    login login_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (usuario);
 :   ALTER TABLE ONLY public.login DROP CONSTRAINT login_pkey;
       public         postgres    false    211                       2606    16709    pagamento pagamento_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.pagamento DROP CONSTRAINT pagamento_pkey;
       public         postgres    false    210                       2606    16662    produto produto_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    204            (           2606    16647    pessoa_juridica fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoa_juridica
    ADD CONSTRAINT fk FOREIGN KEY (juridica_cliente) REFERENCES public.cliente(id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;
 <   ALTER TABLE ONLY public.pessoa_juridica DROP CONSTRAINT fk;
       public       postgres    false    197    202    2837            *           2606    25047    itens_compra fk1    FK CONSTRAINT     �   ALTER TABLE ONLY public.itens_compra
    ADD CONSTRAINT fk1 FOREIGN KEY (id_prod) REFERENCES public.produto(id_produto) ON UPDATE CASCADE ON DELETE CASCADE;
 :   ALTER TABLE ONLY public.itens_compra DROP CONSTRAINT fk1;
       public       postgres    false    218    2841    204            +           2606    25098    itens_compra fk2    FK CONSTRAINT     �   ALTER TABLE ONLY public.itens_compra
    ADD CONSTRAINT fk2 FOREIGN KEY (id_compra) REFERENCES public.compra(id_compra) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
 :   ALTER TABLE ONLY public.itens_compra DROP CONSTRAINT fk2;
       public       postgres    false    219    218    2853            ,           2606    25091    compra fk_comp    FK CONSTRAINT     �   ALTER TABLE ONLY public.compra
    ADD CONSTRAINT fk_comp FOREIGN KEY (id_conta) REFERENCES public.conta(id_conta) ON UPDATE CASCADE ON DELETE CASCADE;
 8   ALTER TABLE ONLY public.compra DROP CONSTRAINT fk_comp;
       public       postgres    false    2843    219    206            )           2606    16710    pagamento fk_fatura    FK CONSTRAINT     �   ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT fk_fatura FOREIGN KEY (id_fatura) REFERENCES public.fatura(id_fatura) ON UPDATE CASCADE ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.pagamento DROP CONSTRAINT fk_fatura;
       public       postgres    false    2845    210    208            &           2606    16612    endereco id_end    FK CONSTRAINT     �   ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT id_end FOREIGN KEY (end_idcliente) REFERENCES public.cliente(id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;
 9   ALTER TABLE ONLY public.endereco DROP CONSTRAINT id_end;
       public       postgres    false    199    2837    197            '           2606    16631    pessoa_fisica pk_in    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoa_fisica
    ADD CONSTRAINT pk_in FOREIGN KEY (id_fisica) REFERENCES public.cliente(id_cliente) ON UPDATE CASCADE ON DELETE CASCADE;
 =   ALTER TABLE ONLY public.pessoa_fisica DROP CONSTRAINT pk_in;
       public       postgres    false    2837    197    201            �   @   x�3��LN����H��4200�4�22�,N,��W( ��Ʀ@Q#.##΢��Ԣ�|NS��=... ��      �   �   x�e��� Dѳ�gX	���눸������-hO����Oc�[6�0���J���0�6R����l��� Y��^�MQ����
��f�:ʮ��e|޺��b���Ⅾ�n�S�-�ߢV�1�4���׵D �ZGTH�q ܺ�iȱ.0&j�t�i}�����q��m}:�Я�2Z*�Nb����r��      �   �   x�m�A� C�p�6�w��?� �|�پ�5/X�h��X�����xҞ�ɬ���k����S_�N��bJ�'C��d�_N��ݝ� g+a���e : : :�:����_�ɜ0�6 &hd�*�YPѽ^��q1#죂l��6\�ZV����]rla�������O�+}�      �   |   x�E�A
1�=��(;YG�<���1��DfW�?>ŏ� }(��q@��X����'�\�(�����0�[�~ޕW<E��|�[�*�d��H�n:�?"&�m��(�������k"��/'�      �      x������ � �      �   }   x�M��� �3S�v��s�:������-jE��*"^�� �����^[��Q�'
1�!'8k��,�=2O-eAP3ޚhܟ |h:a�������{�`H�����M��P~�}�ZK�4�      �   2   x�KL����42426J3�4O4�DscK�D�T�Dôdc�=... 4
�      �      x������ � �      �      x�344�4��2�42����� {a      �   '   x�344�,N,��WH��KKM>�����bN#C�=... ��
(      �   N   x�3�L,*ʯ�46�444�,��+��L*J,���L�/J-���2�LLJLN,I5�4�)4�,�O�H�)��*����� �W�      �   i   x�}��	�0���] ƒS'�,����}5�!�!���x�ˢ����W2�C#�!YFenP=4s#�;��Ki�C��⇍2+���|!�ŕTS.�/6�49     