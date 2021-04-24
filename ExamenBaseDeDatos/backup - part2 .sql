--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-04-23 23:45:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE examen;
--
-- TOC entry 3019 (class 1262 OID 16394)
-- Name: examen; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE examen WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';


ALTER DATABASE examen OWNER TO postgres;

\connect examen

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3008 (class 0 OID 16403)
-- Dependencies: 201
-- Data for Name: Cajeros; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Cajeros" ("Cajero", "NomApels") OVERRIDING SYSTEM VALUE VALUES (1, 'Jose Ojeda');
INSERT INTO public."Cajeros" ("Cajero", "NomApels") OVERRIDING SYSTEM VALUE VALUES (2, 'Fernanda Garcia');
INSERT INTO public."Cajeros" ("Cajero", "NomApels") OVERRIDING SYSTEM VALUE VALUES (3, 'Marcos Guzman');
INSERT INTO public."Cajeros" ("Cajero", "NomApels") OVERRIDING SYSTEM VALUE VALUES (4, 'Lionel Messi');
INSERT INTO public."Cajeros" ("Cajero", "NomApels") OVERRIDING SYSTEM VALUE VALUES (5, 'Cristiano Ronaldo');
INSERT INTO public."Cajeros" ("Cajero", "NomApels") OVERRIDING SYSTEM VALUE VALUES (6, 'Mike Tyson');


--
-- TOC entry 3009 (class 0 OID 16411)
-- Dependencies: 202
-- Data for Name: Maquinas_Registradoras; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Maquinas_Registradoras" ("Maquina", "Piso") OVERRIDING SYSTEM VALUE VALUES (1, 3);
INSERT INTO public."Maquinas_Registradoras" ("Maquina", "Piso") OVERRIDING SYSTEM VALUE VALUES (2, 4);
INSERT INTO public."Maquinas_Registradoras" ("Maquina", "Piso") OVERRIDING SYSTEM VALUE VALUES (3, 2);
INSERT INTO public."Maquinas_Registradoras" ("Maquina", "Piso") OVERRIDING SYSTEM VALUE VALUES (4, 7);
INSERT INTO public."Maquinas_Registradoras" ("Maquina", "Piso") OVERRIDING SYSTEM VALUE VALUES (5, 8);
INSERT INTO public."Maquinas_Registradoras" ("Maquina", "Piso") OVERRIDING SYSTEM VALUE VALUES (6, 13);
INSERT INTO public."Maquinas_Registradoras" ("Maquina", "Piso") OVERRIDING SYSTEM VALUE VALUES (7, 31);


--
-- TOC entry 3007 (class 0 OID 16395)
-- Dependencies: 200
-- Data for Name: Productos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Productos" ("Producto", "Nombre", "Precio") OVERRIDING SYSTEM VALUE VALUES (1, 'Refresco', '15,00 €');
INSERT INTO public."Productos" ("Producto", "Nombre", "Precio") OVERRIDING SYSTEM VALUE VALUES (2, 'Dulces', '3,00 €');
INSERT INTO public."Productos" ("Producto", "Nombre", "Precio") OVERRIDING SYSTEM VALUE VALUES (3, 'Sabritas', '20,00 €');
INSERT INTO public."Productos" ("Producto", "Nombre", "Precio") OVERRIDING SYSTEM VALUE VALUES (4, 'Comida Enlatada', '30,00 €');
INSERT INTO public."Productos" ("Producto", "Nombre", "Precio") OVERRIDING SYSTEM VALUE VALUES (5, 'Cerveza', '25,00 €');


--
-- TOC entry 3010 (class 0 OID 16416)
-- Dependencies: 203
-- Data for Name: Venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Venta" ("Cajero", "Maquina", "Producto") VALUES (1, 2, 1);
INSERT INTO public."Venta" ("Cajero", "Maquina", "Producto") VALUES (2, 1, 4);
INSERT INTO public."Venta" ("Cajero", "Maquina", "Producto") VALUES (1, 1, 1);
INSERT INTO public."Venta" ("Cajero", "Maquina", "Producto") VALUES (1, 5, 3);
INSERT INTO public."Venta" ("Cajero", "Maquina", "Producto") VALUES (5, 2, 3);
INSERT INTO public."Venta" ("Cajero", "Maquina", "Producto") VALUES (1, 2, 5);
INSERT INTO public."Venta" ("Cajero", "Maquina", "Producto") VALUES (4, 3, 1);


--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 205
-- Name: Cajeros_Cajero_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Cajeros_Cajero_seq"', 6, true);


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 206
-- Name: Maquinas_Registradoras_Maquina_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Maquinas_Registradoras_Maquina_seq"', 7, true);


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 204
-- Name: Productos_Producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Productos_Producto_seq"', 5, true);


-- Completed on 2021-04-23 23:45:29

--
-- PostgreSQL database dump complete
--

