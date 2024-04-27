PGDMP     :                    |            Unicl    15.6    15.6 0    F           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            G           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            H           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            I           1262    16621    Unicl    DATABASE     z   CREATE DATABASE "Unicl" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE "Unicl";
                postgres    false            �            1259    73783 
   asignatura    TABLE     �   CREATE TABLE public.asignatura (
    id integer NOT NULL,
    codigo character varying(15),
    nombre_asignatura character varying(30),
    estatus character varying(10),
    carrera_id integer,
    semestre_id integer,
    profesor_id integer
);
    DROP TABLE public.asignatura;
       public         heap    postgres    false            �            1259    73780    carrera    TABLE     �   CREATE TABLE public.carrera (
    id integer NOT NULL,
    codigo character varying(15) NOT NULL,
    nombre_carrera character varying(30) NOT NULL,
    estatus character varying(10) NOT NULL,
    decanato_id integer NOT NULL
);
    DROP TABLE public.carrera;
       public         heap    postgres    false            �            1259    73777    decanato    TABLE     p  CREATE TABLE public.decanato (
    id integer NOT NULL,
    codigo character varying(15) NOT NULL,
    nombre_decanato character varying(50) NOT NULL,
    direccion character varying(50) NOT NULL,
    telefonos character varying(15) NOT NULL,
    email character varying(80) NOT NULL,
    estatus character varying(10) NOT NULL,
    universidad_id integer NOT NULL
);
    DROP TABLE public.decanato;
       public         heap    postgres    false            �            1259    73792 
   estudiante    TABLE       CREATE TABLE public.estudiante (
    id integer NOT NULL,
    codigo character varying(15) NOT NULL,
    nombres character varying(30) NOT NULL,
    apellidos character varying(30) NOT NULL,
    genero character varying(6) NOT NULL,
    direccion character varying(50) NOT NULL,
    telefonos character varying(15) NOT NULL,
    email character varying(80) NOT NULL,
    estatus character varying(10) NOT NULL,
    carrera_id integer NOT NULL,
    semestre_id integer NOT NULL,
    seccion_id integer NOT NULL
);
    DROP TABLE public.estudiante;
       public         heap    postgres    false            �            1259    73776    id    SEQUENCE     z   CREATE SEQUENCE public.id
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.id;
       public          postgres    false            �            1259    81920    inscripcion    TABLE     �   CREATE TABLE public.inscripcion (
    id integer,
    codigo character varying(15),
    fecha date,
    estatus character varying(10),
    lapso_id integer,
    estudiante_id integer,
    asignatura_id integer,
    seccion_id integer
);
    DROP TABLE public.inscripcion;
       public         heap    postgres    false            �            1259    81923    lapso    TABLE     �   CREATE TABLE public.lapso (
    id integer,
    codigo character varying(15),
    fecha_inicial date,
    fecha_final date,
    semana integer,
    "año" integer,
    estatus character varying(10)
);
    DROP TABLE public.lapso;
       public         heap    postgres    false            �            1259    81982    numero    SEQUENCE     ~   CREATE SEQUENCE public.numero
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.numero;
       public          postgres    false            �            1259    73789    profesor    TABLE     �  CREATE TABLE public.profesor (
    id integer NOT NULL,
    codigo character varying(15) NOT NULL,
    nombres character varying(30) NOT NULL,
    apellidos character varying(30) NOT NULL,
    genero character varying(6) NOT NULL,
    direccion character varying(50) NOT NULL,
    telefonos character varying(15) NOT NULL,
    email character varying(80) NOT NULL,
    estatus character varying(10) NOT NULL
);
    DROP TABLE public.profesor;
       public         heap    postgres    false            �            1259    81979    seccion    TABLE     �   CREATE TABLE public.seccion (
    numero integer NOT NULL,
    estatus character varying(10) NOT NULL,
    carrera_id integer NOT NULL
);
    DROP TABLE public.seccion;
       public         heap    postgres    false            �            1259    73786    semestre    TABLE     �   CREATE TABLE public.semestre (
    id integer NOT NULL,
    codigo character varying(15) NOT NULL,
    nombre_semestre character varying(20) NOT NULL,
    estatus character varying(10) NOT NULL
);
    DROP TABLE public.semestre;
       public         heap    postgres    false            �            1259    73773    universidad    TABLE     Q  CREATE TABLE public.universidad (
    id integer NOT NULL,
    codigo character varying(15) NOT NULL,
    nombre_universidad character varying(45) NOT NULL,
    direccion character varying(50) NOT NULL,
    telefonos character varying(15) NOT NULL,
    email character varying(80) NOT NULL,
    estatus character varying(10) NOT NULL
);
    DROP TABLE public.universidad;
       public         heap    postgres    false            �            1259    49246    usuario    TABLE     u   CREATE TABLE public.usuario (
    codigo character varying(10) NOT NULL,
    clave character varying(10) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            <          0    73783 
   asignatura 
   TABLE DATA           r   COPY public.asignatura (id, codigo, nombre_asignatura, estatus, carrera_id, semestre_id, profesor_id) FROM stdin;
    public          postgres    false    219   @<       ;          0    73780    carrera 
   TABLE DATA           S   COPY public.carrera (id, codigo, nombre_carrera, estatus, decanato_id) FROM stdin;
    public          postgres    false    218   �<       :          0    73777    decanato 
   TABLE DATA           u   COPY public.decanato (id, codigo, nombre_decanato, direccion, telefonos, email, estatus, universidad_id) FROM stdin;
    public          postgres    false    217   I=       ?          0    73792 
   estudiante 
   TABLE DATA           �   COPY public.estudiante (id, codigo, nombres, apellidos, genero, direccion, telefonos, email, estatus, carrera_id, semestre_id, seccion_id) FROM stdin;
    public          postgres    false    222    >       @          0    81920    inscripcion 
   TABLE DATA           u   COPY public.inscripcion (id, codigo, fecha, estatus, lapso_id, estudiante_id, asignatura_id, seccion_id) FROM stdin;
    public          postgres    false    223   Q?       A          0    81923    lapso 
   TABLE DATA           `   COPY public.lapso (id, codigo, fecha_inicial, fecha_final, semana, "año", estatus) FROM stdin;
    public          postgres    false    224   �?       >          0    73789    profesor 
   TABLE DATA           p   COPY public.profesor (id, codigo, nombres, apellidos, genero, direccion, telefonos, email, estatus) FROM stdin;
    public          postgres    false    221   �?       B          0    81979    seccion 
   TABLE DATA           >   COPY public.seccion (numero, estatus, carrera_id) FROM stdin;
    public          postgres    false    225   �@       =          0    73786    semestre 
   TABLE DATA           H   COPY public.semestre (id, codigo, nombre_semestre, estatus) FROM stdin;
    public          postgres    false    220   A       8          0    73773    universidad 
   TABLE DATA           k   COPY public.universidad (id, codigo, nombre_universidad, direccion, telefonos, email, estatus) FROM stdin;
    public          postgres    false    215   �A       7          0    49246    usuario 
   TABLE DATA           0   COPY public.usuario (codigo, clave) FROM stdin;
    public          postgres    false    214   B       J           0    0    id    SEQUENCE SET     1   SELECT pg_catalog.setval('public.id', 1, false);
          public          postgres    false    216            K           0    0    numero    SEQUENCE SET     5   SELECT pg_catalog.setval('public.numero', 1, false);
          public          postgres    false    226            �           2606    81931    carrera carrera_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.carrera
    ADD CONSTRAINT carrera_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.carrera DROP CONSTRAINT carrera_pkey;
       public            postgres    false    218            �           2606    81933    decanato decanato_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.decanato
    ADD CONSTRAINT decanato_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.decanato DROP CONSTRAINT decanato_pkey;
       public            postgres    false    217            �           2606    81935    estudiante estudiante_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT estudiante_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT estudiante_pkey;
       public            postgres    false    222            �           2606    81943    asignatura id_asignatura_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT id_asignatura_pkey PRIMARY KEY (id);
 G   ALTER TABLE ONLY public.asignatura DROP CONSTRAINT id_asignatura_pkey;
       public            postgres    false    219            �           2606    81937    profesor profesor_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.profesor
    ADD CONSTRAINT profesor_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.profesor DROP CONSTRAINT profesor_pkey;
       public            postgres    false    221            �           2606    81984    seccion seccion_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT seccion_pkey PRIMARY KEY (numero);
 >   ALTER TABLE ONLY public.seccion DROP CONSTRAINT seccion_pkey;
       public            postgres    false    225            �           2606    81939    semestre semestre_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.semestre
    ADD CONSTRAINT semestre_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.semestre DROP CONSTRAINT semestre_pkey;
       public            postgres    false    220            �           2606    81941    universidad universidad_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.universidad
    ADD CONSTRAINT universidad_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.universidad DROP CONSTRAINT universidad_pkey;
       public            postgres    false    215            �           2606    49281    usuario usuario_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (codigo);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    214            �           2606    81944    asignatura carrera_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT carrera_id_fkey FOREIGN KEY (carrera_id) REFERENCES public.carrera(id) NOT VALID;
 D   ALTER TABLE ONLY public.asignatura DROP CONSTRAINT carrera_id_fkey;
       public          postgres    false    218    3221    219            �           2606    81969    estudiante carrera_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT carrera_id_fkey FOREIGN KEY (carrera_id) REFERENCES public.carrera(id) NOT VALID;
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT carrera_id_fkey;
       public          postgres    false    222    3221    218            �           2606    81985    seccion carrera_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.seccion
    ADD CONSTRAINT carrera_id_fkey FOREIGN KEY (carrera_id) REFERENCES public.carrera(id) NOT VALID;
 A   ALTER TABLE ONLY public.seccion DROP CONSTRAINT carrera_id_fkey;
       public          postgres    false    218    225    3221            �           2606    81959    carrera decanato_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.carrera
    ADD CONSTRAINT decanato_id_fkey FOREIGN KEY (decanato_id) REFERENCES public.decanato(id) NOT VALID;
 B   ALTER TABLE ONLY public.carrera DROP CONSTRAINT decanato_id_fkey;
       public          postgres    false    218    3219    217            �           2606    81954    asignatura profesor_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT profesor_fkey FOREIGN KEY (profesor_id) REFERENCES public.profesor(id) NOT VALID;
 B   ALTER TABLE ONLY public.asignatura DROP CONSTRAINT profesor_fkey;
       public          postgres    false    219    3227    221            �           2606    81990    estudiante seccion_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT seccion_id_fkey FOREIGN KEY (seccion_id) REFERENCES public.seccion(numero) NOT VALID;
 D   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT seccion_id_fkey;
       public          postgres    false    222    225    3231            �           2606    81949    asignatura semestre_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignatura
    ADD CONSTRAINT semestre_id_fkey FOREIGN KEY (semestre_id) REFERENCES public.semestre(id) NOT VALID;
 E   ALTER TABLE ONLY public.asignatura DROP CONSTRAINT semestre_id_fkey;
       public          postgres    false    3225    219    220            �           2606    81974    estudiante semestre_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estudiante
    ADD CONSTRAINT semestre_id_fkey FOREIGN KEY (semestre_id) REFERENCES public.semestre(id) NOT VALID;
 E   ALTER TABLE ONLY public.estudiante DROP CONSTRAINT semestre_id_fkey;
       public          postgres    false    222    3225    220            �           2606    81964    decanato universidad_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.decanato
    ADD CONSTRAINT universidad_id_fkey FOREIGN KEY (universidad_id) REFERENCES public.universidad(id) NOT VALID;
 F   ALTER TABLE ONLY public.decanato DROP CONSTRAINT universidad_id_fkey;
       public          postgres    false    215    3217    217            <   |   x�eͽ
�1��9���
���]С��.!�Pi�]���:���: Gn�^ʕ����R����7p@��
~E�Y��U $��>r徭O���҇NS��K��$��/�Z�D|�S6.      ;   m   x�3�4400���KO��L-�LT��K�/�=��$39��1�$�,�Ә��Έ�1/1'�8�X!%U!8��$57����Ș�'395/93���(Q!5O�7�b ��=... �(A      :   �   x�u��j�0���S�l�8�WJ���^<[�l;)�O?�	���(��>ˁӛ��]��ojV'��/���f�2�.qjc}<.J��@\V?)c�;8��AH��a���}"8�6���`�z��_戊���4ŧ8�a}�
�D��a�	��#[��b_���s
����Z�y������'X�^-n����l���k�^D      ?   !  x�}��j�0��ӧ��4�_��Bǘ0�&��4�6����;j:8�����K�J���L����ps�p0���'1%��a�3C�`��q�@q��Z�PY�ұ*m�������0m������3Y�5���,vb�>xK�wɈ�[�a��¿���,8��u����M�L4,p��X��{s�D����v��瑕%g�����:).t��u�aezCG1C��~«�����D<�ZDPV�����[^Ъj2��o��#�����d,����e�d��k׽��i�$?���      @   ?   x�3���/3202���S���FF�����e�O�P�1>�@&�� ��S`
T���� �0�      A   )   x�3�4202���P���FF ����)�i�t����� ��b      >   �   x�m�AK�0���_�?�@�����"��A�̶QR�f�6����K�i��7<�]QVM]A;�8$�ZA�_pL�%�#}$7�`�F祬�J,��:��y�� m7�K��Ȣ���HE��cO�q��N�	�[1�ɝ"A�Z�S����hΟk�v<؞���<�Xz`�.�Yx�K����1F�,8���?�6%_)�}q���$n}$;m=k�h�X ��6�UeY���{�      B   &   x�3�tL.�,��4400�2B���LPx�(�=... �I�      =   �   x�mͻ!��zx
����-�6��5d��
� ߥ>�_���[���g��G�l	j	"�����&$<8�F�i���7иg�������&��I�I�W%\M��h�%�Һ�ٴV�s���]~      8   i   x��;
�0 �zr��@����[l��fH	�	�����|��m��dg��|��9Q���RL�)A UVB7c��0N�^�{o���,�AY�XX��j~�1�iFo      7      x�KL����L�\1z\\\ 4�     