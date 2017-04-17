

--
-- Name: demotable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE demotable (
    id integer,
    name character(24)
);


ALTER TABLE demotable OWNER TO postgres;

--
-- Data for Name: demotable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY demotable (id, name) FROM stdin;
1	testname                
2	testname2               
3	stefan                  
4	jan                     
5	tjoho                   
6	emelie                  
7	sofie                   
\.


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

