--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

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
-- Name: kursach6; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA kursach6;




SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: messages; Type: TABLE; Schema: kursach6; Owner: postgres
--

CREATE TABLE kursach6.messages (
    messageid integer NOT NULL,
    chatcode character varying(10) NOT NULL,
    usernam character varying(20),
    content character varying(300)
);




--
-- Name: messages_messageid_seq; Type: SEQUENCE; Schema: kursach6; Owner: postgres
--

CREATE SEQUENCE kursach6.messages_messageid_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;




--
-- Name: messages_messageid_seq; Type: SEQUENCE OWNED BY; Schema: kursach6; Owner: postgres
--

ALTER SEQUENCE kursach6.messages_messageid_seq OWNED BY kursach6.messages.messageid;


--
-- Name: users; Type: TABLE; Schema: kursach6; Owner: postgres
--

CREATE TABLE kursach6.users (
    user_id integer NOT NULL,
    name character varying(20),
    password character varying(30)
);




--
-- Name: users_user_id_seq; Type: SEQUENCE; Schema: kursach6; Owner: postgres
--

CREATE SEQUENCE kursach6.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;




--
-- Name: users_user_id_seq; Type: SEQUENCE OWNED BY; Schema: kursach6; Owner: postgres
--

ALTER SEQUENCE kursach6.users_user_id_seq OWNED BY kursach6.users.user_id;


--
-- Name: messages messageid; Type: DEFAULT; Schema: kursach6; Owner: postgres
--

ALTER TABLE ONLY kursach6.messages ALTER COLUMN messageid SET DEFAULT nextval('kursach6.messages_messageid_seq'::regclass);


--
-- Name: users user_id; Type: DEFAULT; Schema: kursach6; Owner: postgres
--

ALTER TABLE ONLY kursach6.users ALTER COLUMN user_id SET DEFAULT nextval('kursach6.users_user_id_seq'::regclass);


--
-- Data for Name: messages; Type: TABLE DATA; Schema: kursach6; Owner: postgres
--




--
-- Data for Name: users; Type: TABLE DATA; Schema: kursach6; Owner: root
--



--
-- Name: messages_messageid_seq; Type: SEQUENCE SET; Schema: kursach6; Owner: postgres
--

SELECT pg_catalog.setval('kursach6.messages_messageid_seq', 312, true);


--
-- Name: users_user_id_seq; Type: SEQUENCE SET; Schema: kursach6; Owner: root
--

SELECT pg_catalog.setval('kursach6.users_user_id_seq', 32, true);


--
-- Name: messages messages_pk; Type: CONSTRAINT; Schema: kursach6; Owner: postgres
--

ALTER TABLE ONLY kursach6.messages
    ADD CONSTRAINT messages_pk PRIMARY KEY (messageid);


--
-- Name: users users_pk; Type: CONSTRAINT; Schema: kursach6; Owner: root
--

ALTER TABLE ONLY kursach6.users
    ADD CONSTRAINT users_pk PRIMARY KEY (user_id);


--
-- Name: messages_messageid_uindex; Type: INDEX; Schema: kursach6; Owner: postgres
--

CREATE UNIQUE INDEX messages_messageid_uindex ON kursach6.messages USING btree (messageid);


--
-- Name: users_name_uindex; Type: INDEX; Schema: kursach6; Owner: root
--

CREATE UNIQUE INDEX users_name_uindex ON kursach6.users USING btree (name);


--
-- Name: users_user_id_uindex; Type: INDEX; Schema: kursach6; Owner: root
--

CREATE UNIQUE INDEX users_user_id_uindex ON kursach6.users USING btree (user_id);


--
-- PostgreSQL database dump complete
--

