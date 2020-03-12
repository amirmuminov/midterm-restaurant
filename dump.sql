PGDMP                         x         
   restaraunt    11.5    11.5 )    -           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            .           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            /           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            0           1262    24997 
   restaraunt    DATABASE     �   CREATE DATABASE restaraunt WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE restaraunt;
             postgres    false            �            1259    25033    category    TABLE     [   CREATE TABLE public.category (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.category;
       public         postgres    false            �            1259    25031    category_id_seq    SEQUENCE     �   CREATE SEQUENCE public.category_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.category_id_seq;
       public       postgres    false    203            1           0    0    category_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.category_id_seq OWNED BY public.category.id;
            public       postgres    false    202            �            1259    25008    income    TABLE     c   CREATE TABLE public.income (
    id integer NOT NULL,
    day date,
    income double precision
);
    DROP TABLE public.income;
       public         postgres    false            �            1259    25006    income_id_seq    SEQUENCE     �   CREATE SEQUENCE public.income_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.income_id_seq;
       public       postgres    false    199            2           0    0    income_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.income_id_seq OWNED BY public.income.id;
            public       postgres    false    198            �            1259    25041    meal    TABLE     �   CREATE TABLE public.meal (
    id integer NOT NULL,
    name character varying(255),
    price double precision,
    category_id integer
);
    DROP TABLE public.meal;
       public         postgres    false            �            1259    25039    meal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.meal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.meal_id_seq;
       public       postgres    false    205            3           0    0    meal_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.meal_id_seq OWNED BY public.meal.id;
            public       postgres    false    204            �            1259    25000    position    TABLE     ]   CREATE TABLE public."position" (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public."position";
       public         postgres    false            �            1259    24998    position_id_seq    SEQUENCE     �   CREATE SEQUENCE public.position_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.position_id_seq;
       public       postgres    false    197            4           0    0    position_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.position_id_seq OWNED BY public."position".id;
            public       postgres    false    196            �            1259    25016    staff    TABLE     �   CREATE TABLE public.staff (
    id integer NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    age integer,
    position_id integer,
    hire_date date DEFAULT CURRENT_DATE,
    base_salary double precision
);
    DROP TABLE public.staff;
       public         postgres    false            �            1259    25014    staff_id_seq    SEQUENCE     �   CREATE SEQUENCE public.staff_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.staff_id_seq;
       public       postgres    false    201            5           0    0    staff_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.staff_id_seq OWNED BY public.staff.id;
            public       postgres    false    200            �
           2604    25036    category id    DEFAULT     j   ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.category_id_seq'::regclass);
 :   ALTER TABLE public.category ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    203    202    203            �
           2604    25011 	   income id    DEFAULT     f   ALTER TABLE ONLY public.income ALTER COLUMN id SET DEFAULT nextval('public.income_id_seq'::regclass);
 8   ALTER TABLE public.income ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198    199            �
           2604    25044    meal id    DEFAULT     b   ALTER TABLE ONLY public.meal ALTER COLUMN id SET DEFAULT nextval('public.meal_id_seq'::regclass);
 6   ALTER TABLE public.meal ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    204    205    205            �
           2604    25003    position id    DEFAULT     l   ALTER TABLE ONLY public."position" ALTER COLUMN id SET DEFAULT nextval('public.position_id_seq'::regclass);
 <   ALTER TABLE public."position" ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            �
           2604    25019    staff id    DEFAULT     d   ALTER TABLE ONLY public.staff ALTER COLUMN id SET DEFAULT nextval('public.staff_id_seq'::regclass);
 7   ALTER TABLE public.staff ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    200    201            (          0    25033    category 
   TABLE DATA               ,   COPY public.category (id, name) FROM stdin;
    public       postgres    false    203   J)       $          0    25008    income 
   TABLE DATA               1   COPY public.income (id, day, income) FROM stdin;
    public       postgres    false    199   t)       *          0    25041    meal 
   TABLE DATA               <   COPY public.meal (id, name, price, category_id) FROM stdin;
    public       postgres    false    205   �)       "          0    25000    position 
   TABLE DATA               .   COPY public."position" (id, name) FROM stdin;
    public       postgres    false    197   �)       &          0    25016    staff 
   TABLE DATA               d   COPY public.staff (id, first_name, last_name, age, position_id, hire_date, base_salary) FROM stdin;
    public       postgres    false    201   �)       6           0    0    category_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.category_id_seq', 3, true);
            public       postgres    false    202            7           0    0    income_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.income_id_seq', 1, true);
            public       postgres    false    198            8           0    0    meal_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.meal_id_seq', 2, true);
            public       postgres    false    204            9           0    0    position_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.position_id_seq', 6, true);
            public       postgres    false    196            :           0    0    staff_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.staff_id_seq', 10, true);
            public       postgres    false    200            �
           2606    25038    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public         postgres    false    203            �
           2606    25013    income income_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.income
    ADD CONSTRAINT income_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.income DROP CONSTRAINT income_pkey;
       public         postgres    false    199            �
           2606    25046    meal meal_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.meal
    ADD CONSTRAINT meal_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.meal DROP CONSTRAINT meal_pkey;
       public         postgres    false    205            �
           2606    25005    position position_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public."position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public."position" DROP CONSTRAINT position_pkey;
       public         postgres    false    197            �
           2606    25025    staff staff_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.staff DROP CONSTRAINT staff_pkey;
       public         postgres    false    201            �
           2606    25047    meal meal_category_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.meal
    ADD CONSTRAINT meal_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.category(id);
 D   ALTER TABLE ONLY public.meal DROP CONSTRAINT meal_category_id_fkey;
       public       postgres    false    2723    203    205            �
           2606    25026    staff staff_position_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_position_id_fkey FOREIGN KEY (position_id) REFERENCES public."position"(id);
 F   ALTER TABLE ONLY public.staff DROP CONSTRAINT staff_position_id_fkey;
       public       postgres    false    197    201    2717            (      x�3�KMO-I,�L������ 5�      $      x�3�4202�50�54�44 �=... 6��      *      x�3�H,.I�4450�4����� 1(�      "      x�3��M�KLO-�2�O�,2b���� V�_      &   I   x�3�t��,��-����/�42�4F�ƺ����@�dy�g��Ur��VpZp�"TrZ���qqq �"K     