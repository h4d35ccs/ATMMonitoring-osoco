--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: financial_devices; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE financial_devices (
    id integer NOT NULL,
    caption character varying(300),
    description character varying(300),
    device_status character varying(50),
    device_instance character varying(100),
    firmware_major_version integer,
    firmware_minor_version integer,
    firmware_build_version integer,
    firmware_revision_version integer,
    firmware_remaining_version character varying(100),
    hot_swappable boolean,
    major_version integer,
    minor_version integer,
    build_version integer,
    revision_version integer,
    remaining_version character varying(100),
    manufacturer character varying(300),
    model character varying(100),
    name character varying(300),
    removable boolean,
    replaceable boolean,
    pm_status character varying(100),
    serial_number character varying(100),
    universal_id character varying(100),
    variant character varying(100),
    terminal_id integer NOT NULL
);


ALTER TABLE public.financial_devices OWNER TO postgres;

--
-- Name: financial_devices_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE financial_devices_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.financial_devices_id_seq OWNER TO postgres;

--
-- Name: financial_devices_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE financial_devices_id_seq OWNED BY financial_devices.id;


--
-- Name: hardware_devices; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE hardware_devices (
    id integer NOT NULL,
    adapter_type character varying(300),
    address_width integer,
    data_width integer,
    architecture character varying(300),
    signature character varying(300),
    product character varying(100),
    capacity bigint,
    caption character varying(300),
    current_clock_speed integer,
    current_language character varying(100),
    current_time_zone integer,
    current_usage integer,
    daylight_in_effect boolean,
    default_ip_gateway character varying(25),
    description character varying(300),
    device_id character varying(300),
    dhcp_enabled boolean,
    dhcp_server character varying(30),
    display_type boolean,
    domain character varying(300),
    ext_clock integer,
    file_system character varying(300),
    free_space bigint,
    hardware_class character varying(100),
    hardware_type character varying(300),
    ip_address character varying(25),
    ip_subnet character varying(25),
    layout character varying(300),
    mac_address character varying(17),
    manufacturer character varying(300),
    max_baud_rate integer,
    model character varying(300),
    monitor_manufacturer character varying(300),
    monitor_type character varying(300),
    name character varying(300),
    net_connection_id character varying(300),
    net_connection_status character varying(100),
    number_of_processors integer,
    partitions integer,
    pixels_per_x_logical_inch integer,
    pixels_per_y_logical_inch integer,
    pointing_type integer,
    primary_bios boolean,
    release_date timestamp without time zone,
    serial_number character varying(300),
    size_ bigint,
    slot_designation character varying(100),
    smbios_version character varying(100),
    smbios_major_version integer,
    smbios_minor_version integer,
    smbios_present boolean,
    speed integer,
    status character varying(300),
    stepping integer,
    tag character varying(300),
    total_physical_memory integer,
    major_version integer,
    minor_version integer,
    build_version integer,
    revision_version integer,
    remaining_version character varying(50),
    workgroup character varying(300),
    colors integer,
    adapter_ram integer,
    bits_per_pixel integer,
    current_bits_per_pixel integer,
    current_horizontal_resolution integer,
    current_number_of_colors bigint,
    current_refresh_rate integer,
    current_vertical_resolution integer,
    horizontal_res integer,
    refresh_rate integer,
    vertical_res integer,
    video_memory integer,
    driver_name character varying(100),
    firmware_revision character varying(50),
    hardware_major_version integer,
    hardware_minor_version integer,
    hardware_build_version integer,
    hardware_revision_version integer,
    hardware_remaining_version character varying(50),
    usb_major_version integer,
    usb_minor_version integer,
    usb_build_version integer,
    usb_revision_version integer,
    usb_remaining_version character varying(50),
    number_of_ports integer,
    interface_index integer,
    max_clock_speed integer,
    max_media_size integer,
    media_type character varying(100),
    protocol_code character varying(300),
    protocol_supported integer,
    bytes_per_sector integer,
    sectors_per_track integer,
    status_info character varying(100),
    total_cylinders integer,
    tracks_per_cylinder integer,
    video_processor character varying(100),
    volume_name character varying(100),
    volume_serial_number character varying(100),
    terminal_id integer
);


ALTER TABLE public.hardware_devices OWNER TO postgres;

--
-- Name: hardware_devices_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hardware_devices_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hardware_devices_id_seq OWNER TO postgres;

--
-- Name: hardware_devices_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hardware_devices_id_seq OWNED BY hardware_devices.id;


--
-- Name: hotfixes; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE hotfixes (
    id integer NOT NULL,
    description character varying(300),
    fix_comments character varying(300),
    hotfix_id character varying(50),
    installed_on timestamp without time zone,
    numbr integer,
    terminal_id integer
);


ALTER TABLE public.hotfixes OWNER TO postgres;

--
-- Name: hotfixes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hotfixes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hotfixes_id_seq OWNER TO postgres;

--
-- Name: hotfixes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hotfixes_id_seq OWNED BY hotfixes.id;


--
-- Name: internet_explorers; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE internet_explorers (
    id integer NOT NULL,
    major_version integer,
    minor_version integer,
    build_version integer,
    revision_version integer,
    remaining_version character varying(100)
);


ALTER TABLE public.internet_explorers OWNER TO postgres;

--
-- Name: internet_explorers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE internet_explorers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.internet_explorers_id_seq OWNER TO postgres;

--
-- Name: internet_explorers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE internet_explorers_id_seq OWNED BY internet_explorers.id;


--
-- Name: logical_cash_units; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE logical_cash_units (
    id integer NOT NULL,
    currency_id character varying(50),
    maximum integer,
    minimum integer,
    name character varying(50),
    type character varying(50),
    unit_id integer,
    vals character varying(150),
    xfs_component_id integer
);


ALTER TABLE public.logical_cash_units OWNER TO postgres;

--
-- Name: logical_cash_units_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE logical_cash_units_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.logical_cash_units_id_seq OWNER TO postgres;

--
-- Name: logical_cash_units_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE logical_cash_units_id_seq OWNED BY logical_cash_units.id;


--
-- Name: operating_systems; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE operating_systems (
    id integer NOT NULL,
    os_language character varying(100),
    os_type character varying(100),
    build_version integer,
    major_version integer,
    manufacturer character varying(100),
    minor_version integer,
    name character varying(300),
    organization character varying(100),
    remaining_version character varying(100),
    revision_version integer,
    serial_number character varying(100),
    service_pack_build_version integer,
    service_pack_major_version integer,
    service_pack_minor_version integer,
    service_pack_remaining_version character varying(100),
    service_pack_revision_version integer
);


ALTER TABLE public.operating_systems OWNER TO postgres;

--
-- Name: operating_systems_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE operating_systems_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.operating_systems_id_seq OWNER TO postgres;

--
-- Name: operating_systems_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE operating_systems_id_seq OWNED BY operating_systems.id;


--
-- Name: physical_cash_units; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE physical_cash_units (
    id integer NOT NULL,
    hardware_sensor boolean,
    maximum integer,
    name character varying(50),
    unit_id integer,
    logical_cash_unit_id integer
);


ALTER TABLE public.physical_cash_units OWNER TO postgres;

--
-- Name: physical_cash_units_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE physical_cash_units_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.physical_cash_units_id_seq OWNER TO postgres;

--
-- Name: physical_cash_units_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE physical_cash_units_id_seq OWNED BY physical_cash_units.id;


--
-- Name: queries; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE queries (
    id integer NOT NULL,
    feat_sw_cb1 boolean,
    feat_sw_cb2 boolean,
    feat_sw_cb3 boolean,
    feat_sw_cb4 boolean,
    feat_sw_cb5 boolean,
    feat_sw_c11 character varying(50),
    feat_sw_c12 character varying(50),
    feat_sw_c21 character varying(50),
    feat_sw_c22 character varying(50),
    feat_sw_c31 character varying(50),
    feat_sw_c32 character varying(50),
    feat_sw_c41 character varying(50),
    feat_sw_c42 character varying(50),
    feat_sw_c51 character varying(50),
    feat_sw_c52 character varying(50),
    feat_sw_f1 character varying(150),
    feat_sw_f2 character varying(150),
    feat_sw_f3 character varying(150),
    feat_sw_f4 character varying(150),
    feat_sw_f5 character varying(150),
    financial_dev_cb1 boolean,
    financial_dev_cb2 boolean,
    financial_dev_cb3 boolean,
    financial_dev_cb4 boolean,
    financial_dev_cb5 boolean,
    financial_dev_c11 character varying(50),
    financial_dev_c12 character varying(50),
    financial_dev_c21 character varying(50),
    financial_dev_c22 character varying(50),
    financial_dev_c31 character varying(50),
    financial_dev_c32 character varying(50),
    financial_dev_c41 character varying(50),
    financial_dev_c42 character varying(50),
    financial_dev_c51 character varying(50),
    financial_dev_c52 character varying(50),
    financial_dev_f1 character varying(150),
    financial_dev_f2 character varying(150),
    financial_dev_f3 character varying(150),
    financial_dev_f4 character varying(150),
    financial_dev_f5 character varying(150),
    hw_device_cb1 boolean,
    hw_device_cb2 boolean,
    hw_device_cb3 boolean,
    hw_device_cb4 boolean,
    hw_device_cb5 boolean,
    hw_device_c11 character varying(50),
    hw_device_c12 character varying(50),
    hw_device_c13 character varying(50),
    hw_device_c21 character varying(50),
    hw_device_c22 character varying(50),
    hw_device_c23 character varying(50),
    hw_device_c31 character varying(50),
    hw_device_c32 character varying(50),
    hw_device_c33 character varying(50),
    hw_device_c41 character varying(50),
    hw_device_c42 character varying(50),
    hw_device_c43 character varying(50),
    hw_device_c51 character varying(50),
    hw_device_c52 character varying(50),
    hw_device_c53 character varying(50),
    hw_device_f1 character varying(150),
    hw_device_f2 character varying(150),
    hw_device_f3 character varying(150),
    hw_device_f4 character varying(150),
    hw_device_f5 character varying(150),
    hotfix_cb1 boolean,
    hotfix_cb2 boolean,
    hotfix_cb3 boolean,
    hotfix_cb4 boolean,
    hotfix_cb5 boolean,
    hotfix_c11 character varying(50),
    hotfix_c12 character varying(50),
    hotfix_c21 character varying(50),
    hotfix_c22 character varying(50),
    hotfix_c31 character varying(50),
    hotfix_c32 character varying(50),
    hotfix_c41 character varying(50),
    hotfix_c42 character varying(50),
    hotfix_c51 character varying(50),
    hotfix_c52 character varying(50),
    hotfix_f1 character varying(150),
    hotfix_f2 character varying(150),
    hotfix_f3 character varying(150),
    hotfix_f4 character varying(150),
    hotfix_f5 character varying(150),
    ie_cb1 boolean,
    ie_cb2 boolean,
    ie_c11 character varying(50),
    ie_c12 character varying(50),
    ie_c21 character varying(50),
    ie_c22 character varying(50),
    ie_f1 character varying(150),
    ie_f2 character varying(150),
    query_name character varying(50) NOT NULL,
    op_system_cb1 boolean,
    op_system_cb2 boolean,
    op_system_cb3 boolean,
    op_system_cb4 boolean,
    op_system_cb5 boolean,
    op_system_c11 character varying(50),
    op_system_c12 character varying(50),
    op_system_c21 character varying(50),
    op_system_c22 character varying(50),
    op_system_c31 character varying(50),
    op_system_c32 character varying(50),
    op_system_c41 character varying(50),
    op_system_c42 character varying(50),
    op_system_c51 character varying(50),
    op_system_c52 character varying(50),
    op_system_f1 character varying(150),
    op_system_f2 character varying(150),
    op_system_f3 character varying(150),
    op_system_f4 character varying(150),
    op_system_f5 character varying(150),
    software_cb1 boolean,
    software_cb2 boolean,
    software_cb3 boolean,
    software_cb4 boolean,
    software_cb5 boolean,
    software_c11 character varying(50),
    software_c12 character varying(50),
    software_c21 character varying(50),
    software_c22 character varying(50),
    software_c31 character varying(50),
    software_c32 character varying(50),
    software_c41 character varying(50),
    software_c42 character varying(50),
    software_c51 character varying(50),
    software_c52 character varying(50),
    software_f1 character varying(150),
    software_f2 character varying(150),
    software_f3 character varying(150),
    software_f4 character varying(150),
    software_f5 character varying(150),
    terminal_cb1 boolean,
    terminal_cb2 boolean,
    terminal_cb3 boolean,
    terminal_cb4 boolean,
    terminal_cb5 boolean,
    terminal_c11 character varying(50),
    terminal_c12 character varying(50),
    terminal_c21 character varying(50),
    terminal_c22 character varying(50),
    terminal_c31 character varying(50),
    terminal_c32 character varying(50),
    terminal_c41 character varying(50),
    terminal_c42 character varying(50),
    terminal_c51 character varying(50),
    terminal_c52 character varying(50),
    terminal_f1 character varying(150),
    terminal_f2 character varying(150),
    terminal_f3 character varying(150),
    terminal_f4 character varying(150),
    terminal_f5 character varying(150),
    xfs_sw_cb1 boolean,
    xfs_sw_cb2 boolean,
    xfs_sw_cb3 boolean,
    xfs_sw_cb4 boolean,
    xfs_sw_cb5 boolean,
    xfs_sw_c11 character varying(50),
    xfs_sw_c12 character varying(50),
    xfs_sw_c21 character varying(50),
    xfs_sw_c22 character varying(50),
    xfs_sw_c31 character varying(50),
    xfs_sw_c32 character varying(50),
    xfs_sw_c41 character varying(50),
    xfs_sw_c42 character varying(50),
    xfs_sw_c51 character varying(50),
    xfs_sw_c52 character varying(50),
    xfs_sw_f1 character varying(150),
    xfs_sw_f2 character varying(150),
    xfs_sw_f3 character varying(150),
    xfs_sw_f4 character varying(150),
    xfs_sw_f5 character varying(150),
    user_id integer
);


ALTER TABLE public.queries OWNER TO postgres;

--
-- Name: queries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE queries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.queries_id_seq OWNER TO postgres;

--
-- Name: queries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE queries_id_seq OWNED BY queries.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE roles (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    manageable boolean DEFAULT true
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE roles_id_seq OWNED BY roles.id;


--
-- Name: scheduled_updates; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE scheduled_updates (
    id integer NOT NULL,
    hours smallint NOT NULL,
    minutes smallint NOT NULL,
    week_day smallint,
    month_day smallint
);


ALTER TABLE public.scheduled_updates OWNER TO postgres;

--
-- Name: scheduled_updates_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE scheduled_updates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.scheduled_updates_id_seq OWNER TO postgres;

--
-- Name: scheduled_updates_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE scheduled_updates_id_seq OWNED BY scheduled_updates.id;


--
-- Name: software; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE software (
    id integer NOT NULL,
    caption character varying(300),
    description character varying(300),
    language character varying(25),
    local_package character varying(100),
    package_name character varying(100),
    product_id character varying(100),
    identifying_number character varying(100),
    install_date timestamp without time zone,
    name character varying(300),
    vendor character varying(100),
    major_version integer,
    minor_version integer,
    build_version integer,
    revision_version integer,
    sw_type character varying(100),
    remaining_version character varying(100)
);


ALTER TABLE public.software OWNER TO postgres;

--
-- Name: software_aggregates; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE software_aggregates (
    id integer NOT NULL,
    description character varying(300),
    numbr integer,
    name character varying(300),
    profile character varying(100),
    major_version integer,
    minor_version integer,
    build_version integer,
    revision_version integer,
    remaining_version character varying(100)
);


ALTER TABLE public.software_aggregates OWNER TO postgres;

--
-- Name: software_aggregates_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE software_aggregates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.software_aggregates_id_seq OWNER TO postgres;

--
-- Name: software_aggregates_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE software_aggregates_id_seq OWNED BY software_aggregates.id;


--
-- Name: software_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE software_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.software_id_seq OWNER TO postgres;

--
-- Name: software_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE software_id_seq OWNED BY software.id;


--
-- Name: t_config_op_system; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE t_config_op_system (
    terminal_config_id integer NOT NULL,
    operating_system_id integer NOT NULL
);


ALTER TABLE public.t_config_op_system OWNER TO postgres;

--
-- Name: terminal_config_software; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE terminal_config_software (
    terminal_config_id integer NOT NULL,
    software_id integer NOT NULL
);


ALTER TABLE public.terminal_config_software OWNER TO postgres;

--
-- Name: terminal_configs; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE terminal_configs (
    id integer NOT NULL,
    start_date timestamp without time zone,
    terminal_id integer NOT NULL
);


ALTER TABLE public.terminal_configs OWNER TO postgres;

--
-- Name: terminal_configs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE terminal_configs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.terminal_configs_id_seq OWNER TO postgres;

--
-- Name: terminal_configs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE terminal_configs_id_seq OWNED BY terminal_configs.id;


--
-- Name: terminal_internet_explorer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE terminal_internet_explorer (
    terminal_id integer NOT NULL,
    internet_explorer_id integer NOT NULL
);


ALTER TABLE public.terminal_internet_explorer OWNER TO postgres;

--
-- Name: terminal_software_aggregate; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE terminal_software_aggregate (
    terminal_id integer NOT NULL,
    software_aggregate_id integer NOT NULL
);


ALTER TABLE public.terminal_software_aggregate OWNER TO postgres;

--
-- Name: terminals; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE terminals (
    id integer NOT NULL,
    front_replenish boolean DEFAULT false,
    geographic_address character varying(300),
    manufacturing_site character varying(100),
    model character varying(100),
    product_class character varying(100),
    product_class_description character varying(200),
    serial_number character varying(100),
    terminal_type character varying(100),
    terminal_vendor character varying(100),
    tracer_number character varying(50),
    address character varying(300),
    area character varying(100),
    bank character varying(100),
    branch character varying(100),
    city character varying(100),
    country character varying(100),
    ip character varying(23) NOT NULL,
    mac character varying(17) NOT NULL,
    zip_code character varying(30)
);


ALTER TABLE public.terminals OWNER TO postgres;

--
-- Name: terminals_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE terminals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.terminals_id_seq OWNER TO postgres;

--
-- Name: terminals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE terminals_id_seq OWNED BY terminals.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer NOT NULL,
    firstname character varying(50),
    lastname character varying(60),
    username character varying(50),
    passw character varying(80),
    last_login timestamp without time zone,
    role_id integer NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: xfs_components; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE xfs_components (
    id integer NOT NULL,
    accept_media boolean,
    algorithms character varying(500),
    autofix boolean,
    auxiliaries character varying(100),
    back_image_color_format character varying(500),
    cameras character varying(200),
    cam_data character varying(200),
    can_open_safe_door boolean,
    cards character varying(500),
    cash_units character varying(500),
    cen_major_version integer,
    cen_minor_version integer,
    cen_build_version integer,
    cen_revision_version integer,
    cen_remaining_version character varying(100),
    char_support character varying(50),
    chip_io boolean,
    chip_power character varying(500),
    chip_protocol character varying(500),
    code_line_format character varying(500),
    compound boolean,
    compare_magnetic_stripe boolean,
    control character varying(100),
    cursor boolean,
    dep_transport boolean,
    derivation_algorithms character varying(500),
    dispense_paper boolean,
    display character varying(500),
    display_light boolean,
    door_safe boolean,
    door_vandal_shield boolean,
    doors character varying(100),
    encoder boolean,
    encode_names character varying(200),
    endorser boolean,
    envelope_supply character varying(200),
    exchange_types character varying(500),
    extents character varying(500),
    extra character varying(1000),
    flux boolean,
    font_names character varying(200),
    forms boolean,
    front_image_color_format character varying(500),
    guidlights character varying(100),
    has_cash_box boolean,
    has_inserted_sensor boolean,
    has_shutter boolean,
    has_taken_sensor boolean,
    id_connect boolean,
    id_key integer,
    image_capture character varying(200),
    image_source character varying(500),
    image_type character varying(500),
    indicators character varying(100),
    intermediate_stacker integer,
    key_check_modes character varying(500),
    key_lock boolean,
    key_num integer,
    logical_name character varying(100),
    magnetic_stripe_read boolean,
    magnetic_stripe_write boolean,
    max_cash_in_items integer,
    max_data_length integer,
    max_dispense_items integer,
    max_media_on_stacker integer,
    max_num_chars integer,
    max_pictures integer,
    max_retract integer,
    media_taken boolean,
    micr boolean,
    move_items character varying(500),
    multi_page boolean,
    num_leds integer,
    ocr boolean,
    paper_sources character varying(500),
    pin_formats character varying(500),
    power_off character varying(100),
    power_on character varying(100),
    presentation_algorithms character varying(500),
    printer boolean,
    print_on_retracts boolean,
    programatically_deactivate boolean,
    read_form character varying(100),
    read_tracks character varying(500),
    read_write_after_eject boolean,
    refill boolean,
    resolution character varying(100),
    resolutions character varying(100),
    retract_areas character varying(500),
    retract_bins character varying(500),
    retract_envelope character varying(200),
    retract_stacker_actions character varying(500),
    retract_transport_actions character varying(500),
    security_type character varying(100),
    sensors character varying(100),
    service_provider character varying(100),
    shutter_control boolean,
    stamp character varying(200),
    supported_positions character varying(500),
    toner boolean,
    type character varying(500),
    validation_algorithms character varying(500),
    vendor character varying(100),
    write_form character varying(100),
    write_mode character varying(100),
    write_tracks character varying(500),
    xfs_class character varying(100) NOT NULL,
    financial_device_id integer NOT NULL
);


ALTER TABLE public.xfs_components OWNER TO postgres;

--
-- Name: xfs_components_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE xfs_components_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.xfs_components_id_seq OWNER TO postgres;

--
-- Name: xfs_components_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE xfs_components_id_seq OWNED BY xfs_components.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY financial_devices ALTER COLUMN id SET DEFAULT nextval('financial_devices_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hardware_devices ALTER COLUMN id SET DEFAULT nextval('hardware_devices_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hotfixes ALTER COLUMN id SET DEFAULT nextval('hotfixes_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY internet_explorers ALTER COLUMN id SET DEFAULT nextval('internet_explorers_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logical_cash_units ALTER COLUMN id SET DEFAULT nextval('logical_cash_units_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY operating_systems ALTER COLUMN id SET DEFAULT nextval('operating_systems_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY physical_cash_units ALTER COLUMN id SET DEFAULT nextval('physical_cash_units_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY queries ALTER COLUMN id SET DEFAULT nextval('queries_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY roles ALTER COLUMN id SET DEFAULT nextval('roles_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY scheduled_updates ALTER COLUMN id SET DEFAULT nextval('scheduled_updates_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY software ALTER COLUMN id SET DEFAULT nextval('software_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY software_aggregates ALTER COLUMN id SET DEFAULT nextval('software_aggregates_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_configs ALTER COLUMN id SET DEFAULT nextval('terminal_configs_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminals ALTER COLUMN id SET DEFAULT nextval('terminals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY xfs_components ALTER COLUMN id SET DEFAULT nextval('xfs_components_id_seq'::regclass);


--
-- Data for Name: financial_devices; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY financial_devices (id, caption, description, device_status, device_instance, firmware_major_version, firmware_minor_version, firmware_build_version, firmware_revision_version, firmware_remaining_version, hot_swappable, major_version, minor_version, build_version, revision_version, remaining_version, manufacturer, model, name, removable, replaceable, pm_status, serial_number, universal_id, variant, terminal_id) FROM stdin;
1	Journal Printer	Thermal Journal Printer	0	65550	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	JPNT-01-PcThermal	f	f		1	14	1	2
4	USB Graphical Operator Panel	USB Graphical Operator Panel	0	65661	\N	\N	\N	\N	1="7.5"	f	\N	\N	\N	\N		\N	NCR	OPP_-01-USBUOP	f	f		1	125	1	2
8	SDC Primary Device	SDC Primary Device	0	65552	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	PRIM-01-SDCPRIMARY	f	f		1	16	0	2
10	Receipt Printer	Thermal Receipt Printer + Sideways + Enhancements	0	65551	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RPNT-01-PcThermal	f	f		1	15	12	2
11	RS232 Bunch Note Acceptor	RS232 Bunch Note Acceptor	0	65636	\N	\N	\N	\N	1="T044  K017  E009  G003 ",2="MBV-A C0129 D0307 V05 F02 P06"	f	\N	\N	\N	\N		\N	NCR	NACC-01-RS232Bunch	f	f		1	100	1	2
14	Mode Switch	Mode Switch	0	65559	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MDSW-01-MODESWITCH	f	f		1	23	0	2
16	Sound	Sound	0	65578	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	SND_-01-PcSound	f	f		1	42	0	2
17	USB Fraud Detection	USB Fraud Detection	2	65708	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ALRM-01-UsbFraudDetection	f	f		1	172	0	2
18	USB GBRU/GBNA	GBNA: 4CF/A RRB DUAL	2	65656	\N	\N	\N	\N	1="AA61",2="EU6913"	f	\N	\N	\N	\N		\N	NCR	NACC-01-GBRU	f	f		1	120	9	2
19	PS/2 Qwerty Keyboard	PS/2 Qwerty Keyboard	0	65655	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	KEYB-01-PcQwertyKeyboardPS2	f	f		1	119	0	2
27	Fascia Light	USB Fascia Light	0	65667	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	FLT_-01-USBFasciaLight	f	f		1	131	1	5
28	Mode Switch	Mode Switch	0	65559	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MDSW-01-MODESWITCH	f	f		1	23	0	5
29	Remote Relay	USB Remote Relay	0	65670	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RRLY-01-USBRemoteRelay	f	f		1	134	1	5
30	Sound	Enhanced Sound	0	65578	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	SND_-01-PcSound	f	f		1	42	3	5
32	USB Graphical Operator Panel	USB Graphical Operator Panel	0	65661	\N	\N	\N	\N	1="7.5"	f	\N	\N	\N	\N		\N	NCR	OPP_-01-USBUOP	f	f		1	125	1	5
33	Advert Light	USB Advert Light	0	65668	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ALT_-01-USBAdvertLight	f	f		1	132	1	5
34	USB Motorised Card Reader Writer	3 track write USB MCRW + Smart Card	0	65673	\N	\N	\N	\N	1="03.40"	f	\N	\N	\N	\N		\N	NCR	MCRW-01-USBMotorised	f	f		1	137	72	5
36	USB Cash Dispenser	Currency Dispenser	2	65691	\N	\N	\N	\N	1="0033"	f	\N	\N	\N	\N		\N	NCR	CASH-01-UsbDispenser	f	f		1	155	1	5
37	Monitor	Monitor + RJ11 Connection	0	65584	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MON_-01-PcMonitor	f	f		1	48	2	5
38	Remote Status Indicators	USB Remote Status Indicators	0	65669	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RSI_-01-USBRemoteStatusInd	f	f		1	133	1	5
39	USB Encrypting Pin Pad 2	USBEPP2 Numeric	0	65688	\N	\N	\N	\N	1="UL101049",2="LGCY_22"	f	\N	\N	\N	\N		\N	NCR	KEYB-01-USBEPP2	f	f		1	152	35	5
40	PS/2 Qwerty Keyboard	PS/2 Qwerty Keyboard	0	65655	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	KEYB-01-PcQwertyKeyboardPS2	f	f		1	119	0	5
41	Media Entry/Exit Indicators	USB Media Entry/Exit Indicators	0	65665	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MEEI-01-USBMediaEntryExitInd	f	f		1	129	1	5
43	USB Touch Screen	USB Touch Screen	0	65657	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	TUCH-01-USBTouchScreen	f	f		1	121	1	5
44	Journal Printer	Thermal Journal Printer	0	65550	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	JPNT-01-PcThermal	f	f		1	14	1	7
45	Remote Relay	SDC Remote Relay	0	65547	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RRLY-01-SdcRemoteRelay	f	f		1	11	0	7
46	EPP BAPE Keyboard	SDC EPPB Secure Numeric and FDKs	0	65635	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	KEYB-01-SdcEPPB	f	f		1	99	162	7
47	Media Entry Indicators	SDC Media Entry Indicators	0	65541	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MEI_-01-SdcMediaEntryIndicators	f	f		1	5	0	7
48	Alarms	SDC Alarms	0	65543	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ALRM-01-SdcAlarms	f	f		1	7	0	7
49	Cash Handler	SDC Currency Dispenser	2	65553	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	CASH-01-SdcDispenser	f	f		1	17	1	7
50	SDC Primary Device	SDC Primary Device	0	65552	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	PRIM-01-SDCPRIMARY	f	f		1	16	0	7
51	Remote Status Indicators	SDC Remote Status Indicators	0	65546	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RSI_-01-SdcRemoteStatusInd	f	f		1	10	0	7
52	Receipt Printer	Thermal Receipt Printer + Sideways + Enhancements	0	65551	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RPNT-01-PcThermal	f	f		1	15	12	7
54	In Service Indicator	SDC In Service Indicator	0	65545	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ISI_-01-SdcInServiceIndicator	f	f		1	9	0	7
55	Mode Switch	Mode Switch	0	65559	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MDSW-01-MODESWITCH	f	f		1	23	0	7
56	Sound	Sound	0	65578	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	SND_-01-PcSound	f	f		1	42	0	7
7	Cash Handler	SDC Currency Dispenser	2	65553	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	CASH-01-SdcDispenser	f	f		JI090911NA000191#01	17	1	2
53	Fascia Light	SDC Fascia Light	0	65544	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	FLT_-01-SdcFasciaLight	f	f		1	8	0	7
3	EPP BAPE Keyboard	SDC EPPB Secure Numeric and FDKs	0	65635	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	KEYB-01-SdcEPPB	f	f		0000702140033950	99	162	2
2	Remote Relay	SDC Remote Relay	0	65547	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RRLY-01-SdcRemoteRelay	f	f		SS091203GD600158	11	0	2
42	Miscellaneous Interface	USB Miscellaneous Interface	0	65686	\N	\N	\N	\N	1="000c"	f	\N	\N	\N	\N		\N	NCR	MISC-01-USBMiscInterface	f	f		SS091203GD600158	150	1	5
15	IMCRW	Track 123 MCRW + Smart Card + CROPF	0	65643	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MCRW-01-RS232Motorised	f	f		8109075186	107	83	2
9	Remote Status Indicators	SDC Remote Status Indicators	0	65546	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RSI_-01-SdcRemoteStatusInd	f	f		SS091203GD600158	10	0	2
12	Fascia Light	SDC Fascia Light	0	65544	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	FLT_-01-SdcFasciaLight	f	f		SS091203GD600158	8	0	2
5	Media Entry Indicators	SDC Media Entry Indicators	0	65541	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MEI_-01-SdcMediaEntryIndicators	f	f		SS091203GD600158	5	0	2
6	Alarms	SDC Alarms	0	65543	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ALRM-01-SdcAlarms	f	f		SS091203GD600158	7	0	2
13	In Service Indicator	SDC In Service Indicator	0	65545	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ISI_-01-SdcInServiceIndicator	f	f		SS091203GD600158	9	0	2
31	Envelope Dispenser	Envelope Dispenser	0	65663	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ENV_-01-USBEnvelopeDispenser	f	f		SS090827GD107628#00	127	1	5
35	Envelope Depository	Envelope Depository With Long Transport	1	65662	\N	\N	\N	\N	1="0015"	f	\N	\N	\N	\N		\N	NCR	DEP_-01-USBDepository	f	f		SS090827GD107628#00	126	2	5
26	USB Receipt Printer	USB 2ST Receipt Printer	0	65674	\N	\N	\N	\N	1="07.15.00.00", 2="04.10.00.00", 3="00.90.00.00"	f	\N	\N	\N	\N		\N	NCR	RPNT-01-UsbThermal	f	f		1	138	2	5
554	Monitor	Monitor + RJ11 Connection	0	65584	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MON_-01-PcMonitor	f	f		1	48	2	4
555	USB Cash Dispenser	Currency Dispenser	4	65691	\N	\N	\N	\N	1="0033"	f	\N	\N	\N	\N		\N	NCR	CASH-01-UsbDispenser	f	f		1	155	1	4
556	USB Anti-Skimming Module	USB Anti-Skimming Module	0	65723	\N	\N	\N	\N	1="00.45",2="02.07"	f	\N	\N	\N	\N		\N	NCR	ALRM-01-UsbAntiSkimmingModule	f	f		1	187	15	4
557	Advert Light	USB Advert Light	0	65668	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ALT_-01-USBAdvertLight	f	f		1	132	1	4
558	USB Encrypting Pin Pad 2	USBEPP2 Numeric	0	65688	\N	\N	\N	\N	1="UL102005",2="LGCY_22"	f	\N	\N	\N	\N		\N	NCR	KEYB-01-USBEPP2	f	f		1	152	35	4
559	Miscellaneous Interface	USB Miscellaneous Interface	0	65686	\N	\N	\N	\N	1="000c"	f	\N	\N	\N	\N		\N	NCR	MISC-01-USBMiscInterface	f	f		1	150	1	4
560	Envelope Depository	Envelope Depository With Long Transport	1	65662	\N	\N	\N	\N	1="0015"	f	\N	\N	\N	\N		\N	NCR	DEP_-01-USBDepository	f	f		1	126	2	4
561	Remote Relay	USB Remote Relay	0	65670	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RRLY-01-USBRemoteRelay	f	f		1	134	1	4
563	Mode Switch	Mode Switch	0	65559	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MDSW-01-MODESWITCH	f	f		1	23	0	4
564	USB Motorised Card Reader Writer	3 track write USB MCRW + Smart Card	0	65673	\N	\N	\N	\N	1="03.40"	f	\N	\N	\N	\N		\N	NCR	MCRW-01-USBMotorised	f	f		1	137	72	4
565	PS/2 Qwerty Keyboard	PS/2 Qwerty Keyboard	0	65655	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	KEYB-01-PcQwertyKeyboardPS2	f	f		1	119	0	4
566	USB Touch Screen	USB Touch Screen	0	65657	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	TUCH-01-USBTouchScreen	f	f		1	121	1	4
567	Fascia Light	USB Fascia Light	0	65667	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	FLT_-01-USBFasciaLight	f	f		1	131	1	4
568	Envelope Dispenser	Envelope Dispenser	0	65663	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	ENV_-01-USBEnvelopeDispenser	f	f		1	127	1	4
569	Media Entry/Exit Indicators	USB Media Entry/Exit Indicators	0	65665	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	MEEI-01-USBMediaEntryExitInd	f	f		1	129	1	4
570	Remote Status Indicators	USB Remote Status Indicators	0	65669	\N	\N	\N	\N		f	\N	\N	\N	\N		\N	NCR	RSI_-01-USBRemoteStatusInd	f	f		1	133	1	4
562	USB 2D Barcode Reader	USB 2D Barcode Reader (Model 5180SR PiD 0x427)	0	65658	\N	\N	\N	\N	1="31205480-035"	f	\N	\N	\N	\N		\N	NCR	BCRD-01-USBBarcode	f	f		AC-46-02850	122	1	4
\.


--
-- Name: financial_devices_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('financial_devices_id_seq', 570, true);


--
-- Data for Name: hardware_devices; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hardware_devices (id, adapter_type, address_width, data_width, architecture, signature, product, capacity, caption, current_clock_speed, current_language, current_time_zone, current_usage, daylight_in_effect, default_ip_gateway, description, device_id, dhcp_enabled, dhcp_server, display_type, domain, ext_clock, file_system, free_space, hardware_class, hardware_type, ip_address, ip_subnet, layout, mac_address, manufacturer, max_baud_rate, model, monitor_manufacturer, monitor_type, name, net_connection_id, net_connection_status, number_of_processors, partitions, pixels_per_x_logical_inch, pixels_per_y_logical_inch, pointing_type, primary_bios, release_date, serial_number, size_, slot_designation, smbios_version, smbios_major_version, smbios_minor_version, smbios_present, speed, status, stepping, tag, total_physical_memory, major_version, minor_version, build_version, revision_version, remaining_version, workgroup, colors, adapter_ram, bits_per_pixel, current_bits_per_pixel, current_horizontal_resolution, current_number_of_colors, current_refresh_rate, current_vertical_resolution, horizontal_res, refresh_rate, vertical_res, video_memory, driver_name, firmware_revision, hardware_major_version, hardware_minor_version, hardware_build_version, hardware_revision_version, hardware_remaining_version, usb_major_version, usb_minor_version, usb_build_version, usb_revision_version, usb_remaining_version, number_of_ports, interface_index, max_clock_speed, max_media_size, media_type, protocol_code, protocol_supported, bytes_per_sector, sectors_per_track, status_info, total_cylinders, tracks_per_cylinder, video_processor, volume_name, volume_serial_number, terminal_id) FROM stdin;
1	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	COM1	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	115200	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
2	\N	\N	\N	\N	\N	\N	512	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
3	\N	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Keyboard	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0000040A	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
4	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	4	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI Slot J11	\N	\N	\N	\N	\N	\N	\N	System Slot 3	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
5	\N	\N	\N	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	Floppy disk drive	FDC\\GENERIC_FLOPPY_DRIVE\\6&1435B2E2&0&0	\N	\N	\N	\N	\N	\N	\N	Win32_FloppyDrive	\N	\N	\N	\N	\N	(Standard floppy disk drives)	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
6	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	COM2	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	115200	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
7	\N	\N	\N	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	USB Human Interface Device	\N	\N	\N	\N	(Standard system devices)	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
8	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	1
9	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000009] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	A8:12:20:52:41:53	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
10	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Composite Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Composite Device	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	1
11	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	1
12	\N	\N	\N	\N	\N	440BX Desktop Reference Platform	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_BaseBoard	\N	\N	\N	\N	\N	Intel Corporation	\N		\N	\N	Base Board	\N	\N	\N	\N	\N	\N	\N	\N	\N	None	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
13	\N	\N	\N	\N	\N	\N	\N	Standard Enhanced PCI to USB Host Controller	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_15AD&DEV_0770&SUBSYS_077015AD&REV_00\\4&47B7341&0&1888	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	(Standard USB Host Controller)	\N	\N	\N	\N	Standard Enhanced PCI to USB Host Controller	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	1
14	\N	32	32	0	\N	\N	\N	x86 Family 6 Model 58 Stepping 9	2492	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Processor	\N	\N	\N	\N	\N	GenuineIntel	\N	\N	\N	\N	Intel Pentium III Xeon processor	\N	\N	1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2492	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
15	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82371AB/EB PCI to USB Universal Host Controller	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_7112&SUBSYS_197615AD&REV_00\\4&47B7341&0&0088	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) 82371AB/EB PCI to USB Universal Host Controller	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	1
16	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	4	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI Slot J12	\N	\N	\N	\N	\N	\N	\N	System Slot 4	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
17	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	ISA Slot J9	\N	\N	\N	\N	\N	\N	\N	System Slot 1	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
18	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	3	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI Slot J14	\N	\N	\N	\N	\N	\N	\N	System Slot 6	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
19	\N	\N	\N	\N	\N	\N	\N	MATSHITA DVD+-RW UJ8D1	\N	\N	\N	\N	\N	\N	\N	IDE\\CDROMMATSHITA_DVD+-RW_UJ8D1__________________D.02____\\3031303030303030303030303030303030303130	\N	\N	\N	\N	\N	\N	\N	Win32_CDROMDrive	\N	\N	\N	\N	\N	(Standard CD-ROM drives)	\N	\N	\N	\N	MATSHITA DVD+-RW UJ8D1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
20	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000010] Deterministic Network Enhancer Miniport	\N	\N	\N	\N	\N		Deterministic Network Enhancer Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	A8:12:20:52:41:53	Deterministic Networks	\N	\N	\N	\N	Deterministic Network Enhancer Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
21	\N	\N	\N	\N	\N	\N	\N	VMware Pointing Device	\N	\N	\N	\N	\N	\N	VMware Pointing Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	VMware Pointing Device	\N	\N	\N	\N	VMware, Inc.	\N	\N	\N	\N	VMware Pointing Device	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
22	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	1
23	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	Local Fixed Disk	C:	\N	\N	\N	\N	\N	NTFS	24516	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	40950	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		D4162A9A	1
24	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	ISA Slot J10	\N	\N	\N	\N	\N	\N	\N	System Slot 2	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
25	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Bios	\N	\N	\N	\N	\N	Phoenix Technologies LTD	\N	\N	\N	\N	PhoenixBIOS 4.0 Release 6.0	\N	\N	\N	\N	\N	\N	\N	t	2009-12-31 00:00:00	VMware-56 4d 6c 16 c2 c0 9b 13-86 f1 28 f7 86 b1 cf e8	\N	\N	6.00	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	INTEL  - 6040000	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
26	\N	\N	\N	\N	512	\N	\N	VMware, VMware Virtual S SCSI Disk Device	\N	\N	\N	\N	\N	\N	Disk drive	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	\N	\N	\N	\N	Win32_DiskDrive	\N	\N	\N	\N	\N	(Standard disk drives)	\N	VMware, VMware Virtual S SCSI Disk Device	\N	\N	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	83880720	\N	\N	\N	\N	\N		40957	\N	\N	\N	\N	\N	\N	40957	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	Fixed\thard disk media	\N	\N	56	1497870	\N	5874	255	\N	\N	\N	1
27	\N	\N	\N	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	USB Human Interface Device	\N	\N	\N	\N	(Standard system devices)	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
28	\N	\N	\N	\N	\N	\N	\N	Default Monitor	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor1	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N		Default Monitor	Default Monitor	\N	\N	\N	\N	96	96	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
29	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	4	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI Slot J13	\N	\N	\N	\N	\N	\N	\N	System Slot 5	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
30	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	VMware SVGA II	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	VMware SVGA II	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	128	\N	32	1600	4294967296	60	900	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	VMware SVGA II	\N	\N	1
31	\N	\N	\N	\N	\N	\N	\N	Creative AudioPCI (ES1371,ES1373) (WDM)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SoundDevice	\N	\N	\N	\N	\N	Creative Technology Ltd.	\N	\N	\N	\N	Creative AudioPCI (ES1371,ES1373) (WDM)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
32	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000001] VMware Accelerated AMD PCNet Adapter	\N	\N	\N	\N	\N		VMware Accelerated AMD PCNet Adapter	\N	t	192.127.231.104	\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N	135.130.15.106	255.255.255.0	\N	00:0C:29:B1:CF:E8	VMware, Inc.	\N	\N	\N	\N	VMware Accelerated AMD PCNet Adapter	Local Area Connection	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
33	\N	\N	\N	\N	\N	\N	\N	VMware SCSI Controller	\N	\N	\N	\N	\N	\N	VMware SCSI Controller	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SCSIController	\N	\N	\N	\N	\N	VMware, Inc.	\N	\N	\N	\N	VMware SCSI Controller	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	vmscsi	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	3	\N	\N	\N	\N	\N	1
34	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	ISA Slot J8	\N	\N	\N	\N	\N	\N	\N	System Slot 0	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
35	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	Win32_ParallelPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
36	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000003] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	00:0C:29:B1:CF:E8	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
37	\N	\N	\N	\N	\N	\N	\N	CAJERO-B090D440	\N	\N	60	\N	f	\N	AT/AT COMPATIBLE	\N	\N	\N	\N	WORKGROUP	\N	\N	\N	Win32_ComputerSystem	\N	\N	\N	\N	\N	VMware, Inc.	\N	VMware Virtual Platform	\N	\N	CAJERO-B090D440	\N	\N	1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	536330240	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
38	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	CD-ROM Disc	D:	\N	\N	\N	\N	\N	Desconocido	0	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Desconocido	00000000	1
39	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000011] Deterministic Network Enhancer Miniport	\N	\N	\N	\N	\N		Deterministic Network Enhancer Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	00:0C:29:B1:CF:E8	Deterministic Networks	\N	\N	\N	\N	Deterministic Network Enhancer Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	1
40	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB Universal Host Controller - 24C4	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_24C4&SUBSYS_24C28086&REV_02\\3&13C0B0C5&0&E9	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB Universal Host Controller - 24C4	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	2
41	\N	\N	\N	\N	\N	i845G-W83627	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_BaseBoard	\N	\N	\N	\N	\N		\N		\N	\N	Base Board	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
42	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82845G/GL/GE/PE/GV Graphics Controller	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82845G/GL/GE/PE/GV Graphics Controller	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	32	\N	32	800	4294967296	60	600	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	RADEON 7000 (0x5159)	\N	\N	2
43	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	UdxUsb Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	UdxUsb Device	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	2
44	\N	32	32	0	\N	\N	\N	x86 Family 15 Model 2 Stepping 9	2814	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	133	\N	\N	Win32_Processor	\N	\N	\N	\N	\N	GenuineIntel	\N	\N	\N	\N	Intel(R) Pentium(R) 4 CPU 2.80GHz	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2814	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
45	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB Universal Host Controller - 24C7	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_24C7&SUBSYS_24C28086&REV_02\\3&13C0B0C5&0&EA	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB Universal Host Controller - 24C7	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	2
46	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	3	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	AGP	\N	\N	\N	\N	\N	\N	\N	System Slot 8	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
47	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	Win32_ParallelPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
48	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	Local Fixed Disk	C:	\N	\N	\N	\N	\N	NTFS	65942	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	76316	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		703E4EAC	2
49	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	2
50	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	ISA	\N	\N	\N	\N	\N	\N	\N	System Slot 1	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
51	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	2
52	\N	\N	\N	\N	\N	\N	\N	GBNA	\N	\N	60	\N	f	\N	AT/AT COMPATIBLE	\N	\N	\N	\N	CAJEROS	\N	\N	\N	Win32_ComputerSystem	\N	\N	\N	\N	\N	INTELR	\N	NCR Talladega1	\N	\N	GBNA	\N	\N	1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	527941632	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
53	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	2
54	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	4	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI3	\N	\N	\N	\N	\N	\N	\N	System Slot 7	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
55	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	ISA	\N	\N	\N	\N	\N	\N	\N	System Slot 3	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
56	\N	\N	\N	\N	\N	\N	\N	\N	\N	n|US|iso8859-1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Bios	\N	\N	\N	\N	\N	Phoenix Technologies, LTD	\N	\N	\N	\N	Phoenix - AwardBIOS v6.00PG	\N	\N	\N	\N	\N	\N	\N	t	2004-11-17 00:00:00		\N	\N	NCR PIVAT BIOS V2.01	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	IntelR - 42302e31	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
57	\N	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Keyboard	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0000040A	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
58	\N	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	NCR Self-Service Keyboard	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Keyboard	\N	\N	\N	NCR Self-Service Keyboard	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0000040A	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
59	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	2
60	\N	\N	\N	\N	\N	\N	\N	Realtek AC'97 Audio	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SoundDevice	\N	\N	\N	\N	\N	Realtek	\N	\N	\N	\N	Realtek AC'97 Audio	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
61	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	2
62	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	3	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI2	\N	\N	\N	\N	\N	\N	\N	System Slot 6	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
63	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	ISA	\N	\N	\N	\N	\N	\N	\N	System Slot 2	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
64	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM4)	\N	\N	\N	\N	\N	\N	\N	COM4	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM4)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
65	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	RADEON 7000 / RADEON VE Family (Microsoft Corporation)	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	RADEON 7000 / RADEON VE Family (Microsoft Corporation)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	64	\N	32	1024	4294967296	60	768	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82845G Graphics Controller	\N	\N	2
66	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000009] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	00:01:29:13:C9:B4	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
67	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM3)	\N	\N	\N	\N	\N	\N	\N	COM3	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM3)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
68	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000007] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	86:48:20:52:41:53	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
69	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000008] Intel(R) PRO/100 VE Network Connection	\N	\N	\N	\N	\N		Intel(R) PRO/100 VE Network Connection	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N	135.130.13.103	255.255.255.0	\N	00:01:29:13:C9:B4	Intel	\N	\N	\N	\N	Intel(R) PRO/100 VE Network Connection	Local Area Connection	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
70	\N	\N	\N	\N	\N	\N	512	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
71	\N	\N	\N	\N	\N	\N	\N	USB HID Touch Screen Controller	\N	\N	\N	\N	\N	\N	USB HID Touch Screen Controller	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	USB HID Touch Screen Controller	\N	\N	\N	\N	Microchip Technology, Inc.	\N	\N	\N	\N	USB HID Touch Screen Controller	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
72	\N	\N	\N	\N	\N	\N	\N	TSSTcorp DVD-ROM SH-D162D	\N	\N	\N	\N	\N	\N	\N	IDE\\CDROMTSSTCORP_DVD-ROM_SH-D162D_______________SB00____\\5&163B4B11&0&0.1.0	\N	\N	\N	\N	\N	\N	\N	Win32_CDROMDrive	\N	\N	\N	\N	\N	(Standard CD-ROM drives)	\N	\N	\N	\N	TSSTcorp DVD-ROM SH-D162D	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
73	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	3	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI0	\N	\N	\N	\N	\N	\N	\N	System Slot 4	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
74	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB Universal Host Controller - 24C2	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_24C2&SUBSYS_24C28086&REV_02\\3&13C0B0C5&0&E8	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB Universal Host Controller - 24C2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	2
75	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	ISA	\N	\N	\N	\N	\N	\N	\N	System Slot 0	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
76	\N	\N	\N	\N	\N	\N	\N	Dell P791	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor1	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N	Dell Computer Corp.	Dell P791	Dell P791	\N	\N	\N	\N	96	96	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
77	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	COM1	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
78	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	CD-ROM Disc	D:	\N	\N	\N	\N	\N	Desconocido	0	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Desconocido	00000000	2
79	\N	\N	\N	\N	\N	\N	\N	System Slot	\N	\N	\N	3	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SystemSlot	\N	\N	\N	\N	\N		\N	\N	\N	\N	System Slot	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	PCI1	\N	\N	\N	\N	\N	\N	\N	System Slot 5	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
80	\N	\N	\N	\N	\N	\N	\N	Plug and Play Monitor	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor2	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N	(Standard monitor types)	Plug and Play Monitor	Plug and Play Monitor	\N	\N	\N	\N	96	96	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
81	\N	\N	\N	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	Floppy disk drive	FDC\\GENERIC_FLOPPY_DRIVE\\5&745E7FA&0&0	\N	\N	\N	\N	\N	\N	\N	Win32_FloppyDrive	\N	\N	\N	\N	\N	(Standard floppy disk drives)	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
82	\N	\N	\N	\N	\N	\N	\N	PS/2 Compatible Mouse	\N	\N	\N	\N	\N	\N	PS/2 Compatible Mouse	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	PS/2 Compatible Mouse	\N	\N	\N	\N	Microsoft	\N	\N	\N	\N	PS/2 Compatible Mouse	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
83	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	COM2	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2
84	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB 2.0 Enhanced Host Controller - 24CD	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_24CD&SUBSYS_100815BD&REV_02\\3&13C0B0C5&0&EF	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) 82801DB/DBM USB 2.0 Enhanced Host Controller - 24CD	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	2
85	\N	\N	\N	\N	512	\N	\N	ST380215A	\N	\N	\N	\N	\N	\N	Disk drive	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	\N	\N	\N	\N	Win32_DiskDrive	\N	\N	\N	\N	\N	(Standard disk drives)	\N	ST380215A	\N	\N	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	156296385	\N	\N	\N	\N	\N		76316	\N	\N	\N	\N	\N	\N	76316	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	Fixed\thard disk media	\N	\N	63	2480895	\N	9729	255	\N	\N	\N	2
205	\N	\N	\N	\N	\N	\N	\N	\N	\N	en|US|iso8859-1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Bios	\N	\N	\N	\N	\N	American Megatrends Inc.	\N	\N	\N	\N	BIOS Date: 01/24/11 11:24:07 Ver: 08.00.15	\N	\N	\N	\N	\N	\N	\N	t	2011-01-24 00:00:00	xxx-xxxxxxxx	\N	\N	080015	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	NEC    - 1001124	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
206	\N	\N	\N	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	Floppy disk drive	FDC\\GENERIC_FLOPPY_DRIVE\\5&C1E6F09&0&0	\N	\N	\N	\N	\N	\N	\N	Win32_FloppyDrive	\N	\N	\N	\N	\N	(Standard floppy disk drives)	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
207	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	CD-ROM Disc	D:	\N	\N	\N	\N	\N	Desconocido	0	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Desconocido	00000000	5
208	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Printing Support	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Printing Support	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
209	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 283A	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_283A&SUBSYS_283A8086&REV_02\\3&11583659&1&D7	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 283A	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	5
210	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2835	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2835&SUBSYS_28358086&REV_02\\3&11583659&1&D1	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2835	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	5
211	\N	\N	\N	\N	\N	\N	\N	USB HID Touch Screen Controller	\N	\N	\N	\N	\N	\N	USB HID Touch Screen Controller	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	USB HID Touch Screen Controller	\N	\N	\N	\N	Microchip Technology, Inc.	\N	\N	\N	\N	USB HID Touch Screen Controller	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
212	\N	\N	\N	\N	\N	\N	\N	Default Monitor	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor1	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N	(Standard monitor types)	Default Monitor	Default Monitor	\N	\N	\N	\N	96	96	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
213	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	128	\N	32	800	4294967296	60	600	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R) GMA 3000	\N	\N	5
214	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
215	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	Win32_ParallelPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
216	\N	\N	\N	\N	\N	\N	1024	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
217	\N	32	32	0	\N	\N	\N	x86 Family 6 Model 15 Stepping 13	2127	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	267	\N	\N	Win32_Processor	\N	\N	\N	\N	\N	GenuineIntel	\N	\N	\N	\N	Intel(R) Core(TM)2 Duo CPU     E6400  @ 2.13GHz	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2127	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
218	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2831	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2831&SUBSYS_28318086&REV_02\\3&11583659&1&E9	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2831	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	5
219	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
220	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	COM1	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	115200	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
221	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	Local Fixed Disk	C:	\N	\N	\N	\N	\N	NTFS	69799	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	76316	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		40002EE4	5
222	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000009] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	10:1C:20:52:41:53	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
223	\N	\N	\N	\N	\N	\N	1024	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
224	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
225	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
226	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
227	\N	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Keyboard	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0000040A	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
228	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	128	\N	16	640	65536	60	480	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R) GMA 3000	\N	\N	5
229	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Composite Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Composite Device	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
230	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Zytronic USB Sensor	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Zytronic USB Sensor	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
231	\N	\N	\N	\N	\N	\N	\N	Universal Pointer Device Driver	\N	\N	\N	\N	\N	\N	Universal Pointer Device Driver	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	Universal Pointer Device Driver	\N	\N	\N	\N	Touch-Base	\N	\N	\N	\N	Universal Pointer Device Driver	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
232	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2832	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2832&SUBSYS_28328086&REV_02\\3&11583659&1&EA	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2832	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	5
233	\N	\N	\N	\N	512	\N	\N	ST380215AS	\N	\N	\N	\N	\N	\N	Disk drive	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	\N	\N	\N	\N	Win32_DiskDrive	\N	\N	\N	\N	\N	(Standard disk drives)	\N	ST380215AS	\N	\N	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	156296385	\N	\N	\N	\N	\N		76316	\N	\N	\N	\N	\N	\N	76316	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	Fixed\thard disk media	\N	\N	63	2480895	\N	9729	255	\N	\N	\N	5
234	\N	\N	\N	\N	\N	\N	\N	Plug and Play Monitor	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor2	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N	(Standard monitor types)	Plug and Play Monitor	Plug and Play Monitor	\N	\N	\N	\N	96	96	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
235	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2830	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2830&SUBSYS_28308086&REV_02\\3&11583659&1&E8	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2830	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	5
236	\N	32	32	0	\N	\N	\N	x86 Family 6 Model 15 Stepping 13	2128	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	267	\N	\N	Win32_Processor	\N	\N	\N	\N	\N	GenuineIntel	\N	\N	\N	\N	Intel(R) Core(TM)2 Duo CPU     E6400  @ 2.13GHz	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2128	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
237	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000001] Intel(R) 82566DM Gigabit Network Connection	\N	\N	\N	\N	\N		Intel(R) 82566DM Gigabit Network Connection	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N	135.130.13.118	255.255.255.0	\N	00:1A:D4:0A:A3:B3	Intel	\N	\N	\N	\N	Intel(R) 82566DM Gigabit Network Connection	Local Area Connection	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
238	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	COM2	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	115200	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
239	\N	\N	\N	\N	\N	\N	\N	TSSTcorp DVD-ROM SH-D163B	\N	\N	\N	\N	\N	\N	\N	IDE\\CDROMTSSTCORP_DVD-ROM_SH-D163B_______________SB02____\\5&2C10CE6C&0&0.0.0	\N	\N	\N	\N	\N	\N	\N	Win32_CDROMDrive	\N	\N	\N	\N	\N	(Standard CD-ROM drives)	\N	\N	\N	\N	TSSTcorp DVD-ROM SH-D163B	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
240	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000003] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	00:1A:D4:0A:A3:B3	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
241	\N	\N	\N	\N	\N	\N	\N	Realtek High Definition Audio	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SoundDevice	\N	\N	\N	\N	\N	Realtek	\N	\N	\N	\N	Realtek High Definition Audio	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
242	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 2836	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2836&SUBSYS_28368086&REV_02\\3&11583659&1&EF	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 2836	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	5
243	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
244	\N	\N	\N	\N	\N	Talladega	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_BaseBoard	\N	\N	\N	\N	\N	NCR Corporation	\N		\N	\N	Base Board	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
245	\N	\N	\N	\N	\N	\N	\N	BBK-7543A42DCB9	\N	\N	60	\N	f	\N	AT/AT COMPATIBLE	\N	\N	\N	\N	WORKGROUP	\N	\N	\N	Win32_ComputerSystem	\N	\N	\N	\N	\N	NCR Corporation	\N	xxxx-xxxx-xxxx	\N	\N	BBK-7543A42DCB9	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	2121379840	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
246	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
247	\N	\N	\N	\N	\N	\N	\N	Microsoft PS/2 Mouse	\N	\N	\N	\N	\N	\N	Microsoft PS/2 Mouse	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	Microsoft PS/2 Mouse	\N	\N	\N	\N	Microsoft	\N	\N	\N	\N	Microsoft PS/2 Mouse	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	5
248	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
249	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	5
250	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2834	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2834&SUBSYS_28348086&REV_02\\3&11583659&1&D0	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2834	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	5
275	\N	\N	\N	\N	\N	\N	\N	ESS 1969 PCI AudioDrive (WDM)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_SoundDevice	\N	\N	\N	\N	\N	ESS Technology, Inc.	\N	\N	\N	\N	ESS 1969 PCI AudioDrive (WDM)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
276	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	Win32_ParallelPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
277	\N	32	32	0	\N	\N	\N	x86 Family 6 Model 8 Stepping 6	695	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	100	\N	\N	Win32_Processor	\N	\N	\N	\N	\N	GenuineIntel	\N	\N	\N	\N	Intel Pentium III processor	\N	\N	1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	695	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
278	\N	\N	\N	\N	\N	16582731	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_BaseBoard	\N	\N	\N	\N	\N	Mitsubishi Electric Motherboard Division	\N		\N	\N	Base Board	\N	\N	\N	\N	\N	\N	\N	\N	\N	1999999	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
279	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Bios	\N	\N	\N	\N	\N	Phoenix Technologies LTD	\N	\N	\N	\N	@(#)BIOS Version 16.86, 30th July 2003	\N	\N	\N	\N	\N	\N	\N	t	2003-07-30 00:00:00		\N	\N	4.06 Mitsubishi V16.86	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	PTLTD  - 0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
280	\N	\N	\N	\N	\N	\N	\N	Default Monitor	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor1	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N	(Standard monitor types)	Default Monitor	Default Monitor	\N	\N	\N	\N	96	96	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
282	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	7
283	\N	\N	\N	\N	\N	\N	\N	Intel(R) 82371AB/EB PCI to USB Universal Host Controller	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_7112&SUBSYS_00000000&REV_01\\3&61AAA01&1&3A	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) 82371AB/EB PCI to USB Universal Host Controller	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	7
284	\N	\N	\N	\N	\N	\N	256	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
285	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	Local Fixed Disk	C:	\N	\N	\N	\N	\N	NTFS	34621	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	38162	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		E0D1A267	7
286	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	COM1	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
281	\N	\N	\N	\N	\N	\N	\N	CAJERO0000000	\N	\N	60	\N	f	\N	AT/AT COMPATIBLE	\N	\N	\N	\N	CAJEROS	\N	\N	\N	Win32_ComputerSystem	\N	\N	\N	\N	\N	\N	\N	Manufacturer Data Incorrect	\N	\N	CAJERO0000000	\N	\N	1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	536383488	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
287	\N	\N	\N	\N	512	\N	\N	ST340015A	\N	\N	\N	\N	\N	\N	Disk drive	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	\N	\N	\N	\N	Win32_DiskDrive	\N	\N	\N	\N	\N	(Standard disk drives)	\N	ST340015A	\N	\N	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	78156225	\N	\N	\N	\N	\N		38162	\N	\N	\N	\N	\N	\N	38162	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	Fixed\thard disk media	\N	\N	63	1240575	\N	4865	255	\N	\N	\N	7
288	\N	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Keyboard	\N	\N	\N	Standard 101/102-Key or Microsoft Natural PS/2 Keyboard	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0000040A	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
289	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	CD-ROM Disc	D:	\N	\N	\N	\N	\N	Desconocido	0	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Desconocido	00000000	7
290	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice		\N	\N	\N	\N		\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
291	\N	\N	\N	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	Floppy disk drive	FDC\\GENERIC_FLOPPY_DRIVE\\6&4E71809&0&0	\N	\N	\N	\N	\N	\N	\N	Win32_FloppyDrive	\N	\N	\N	\N	\N	(Standard floppy disk drives)	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
292	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM4)	\N	\N	\N	\N	\N	\N	\N	COM4	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM4)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Error	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
293	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	COM2	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
294	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	ATI Technologies, Inc. 3D RAGE PRO AGP 2X	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	ATI Technologies, Inc. 3D RAGE PRO AGP 2X	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4	\N	16	800	65536	60	600	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	ATI 3D RAGE PRO AGP 2X (GT-C2U2)	\N	\N	7
295	\N	\N	\N	\N	\N	\N	256	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
296	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM3)	\N	\N	\N	\N	\N	\N	\N	COM3	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM3)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Error	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
297	\N	\N	\N	\N	\N	\N	\N	TSSTcorp CD-ROM  SH-C522C	\N	\N	\N	\N	\N	\N	\N	IDE\\CDROMTSSTCORP_CD-ROM__SH-C522C_______________TS02____\\5&13324CED&0&0.1.0	\N	\N	\N	\N	\N	\N	\N	Win32_CDROMDrive	\N	\N	\N	\N	\N	(Standard CD-ROM drives)	\N	\N	\N	\N	TSSTcorp CD-ROM  SH-C522C	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
298	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000007] 3Com EtherLink XL 10/100 PCI For Complete PC Management NIC (3C905C-TX)	\N	\N	\N	\N	\N		3Com EtherLink XL 10/100 PCI For Complete PC Management NIC (3C905C-TX)	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N	135.130.12.12	255.255.255.0	\N	00:04:75:D9:2D:17	3Com	\N	\N	\N	\N	3Com EtherLink XL 10/100 PCI For Complete PC Management NIC (3C905C-TX)	Local Area Connection	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	7
2242	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2243	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	COM2	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	115200	\N	\N	\N	Communications Port (COM2)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2244	\N	\N	\N	\N	\N	\N	\N	TEAC DV-518GS	\N	\N	\N	\N	\N	\N	\N	IDE\\CDROMTEAC_DV-518GS___________________________RT14____\\5&2C10CE6C&0&0.0.0	\N	\N	\N	\N	\N	\N	\N	Win32_CDROMDrive	\N	\N	\N	\N	\N	(Standard CD-ROM drives)	\N	\N	\N	\N	TEAC DV-518GS	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2245	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000003] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	00:1A:D4:17:97:20	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2246	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2831	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2831&SUBSYS_28318086&REV_02\\3&11583659&1&E9	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2831	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	4
2247	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Zytronic USB Sensor	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Zytronic USB Sensor	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2248	\N	\N	\N	\N	\N	\N	1024	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2249	\N	\N	\N	\N	\N	\N	1024	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PhysicalMemory	\N	\N	\N	\N	\N		\N	\N	\N	\N	Physical Memory	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2250	\N	\N	\N	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	USB Human Interface Device	\N	\N	\N	\N	(Standard system devices)	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2251	\N	\N	\N	\N	\N	\N	\N	E:	\N	\N	\N	\N	\N	\N	CD-ROM Disc	E:	\N	\N	\N	\N	\N	Desconocido	0	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	E:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Desconocido	00000000	4
2252	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2253	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 283A	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_283A&SUBSYS_283A8086&REV_02\\3&11583659&1&D7	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 283A	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	4
2254	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2255	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2256	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2257	\N	\N	\N	\N	\N	\N	\N	Universal Pointer Device Driver	\N	\N	\N	\N	\N	\N	Universal Pointer Device Driver	\N	\N	\N	\N	\N	\N	\N	\N	Win32_PointingDevice	Universal Pointer Device Driver	\N	\N	\N	\N	Touch-Base	\N	\N	\N	\N	Universal Pointer Device Driver	\N	\N	\N	\N	\N	\N	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2258	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	Local Fixed Disk	C:	\N	\N	\N	\N	\N	NTFS	69982	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	C:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	78625	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		40002EE4	4
2259	\N	\N	\N	\N	\N	\N	\N	Default Monitor	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor1	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N	(Standard monitor types)	Default Monitor	Default Monitor	\N	\N	\N	\N	96	96	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2260	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000009] Packet Scheduler Miniport	\N	\N	\N	\N	\N		Packet Scheduler Miniport	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N			\N	4A:7D:20:52:41:53	Microsoft	\N	\N	\N	\N	Packet Scheduler Miniport			\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2261	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2262	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2263	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 2836	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2836&SUBSYS_28368086&REV_02\\3&11583659&1&EF	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB2 Enhanced Host Controller - 2836	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	4
2264	\N	\N	\N	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	Floppy disk drive	FDC\\GENERIC_FLOPPY_DRIVE\\5&C1E6F09&0&0	\N	\N	\N	\N	\N	\N	\N	Win32_FloppyDrive	\N	\N	\N	\N	\N	(Standard floppy disk drives)	\N	\N	\N	\N	Floppy disk drive	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2265	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2266	\N	\N	\N	\N	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	COM1	\N	\N	\N	\N	\N	\N	\N	Win32_SerialPort	\N	\N	\N	\N	\N	\N	115200	\N	\N	\N	Communications Port (COM1)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2267	\N	32	32	0	\N	\N	\N	x86 Family 6 Model 23 Stepping 10	2127	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	333	\N	\N	Win32_Processor	\N	\N	\N	\N	\N	GenuineIntel	\N	\N	\N	\N	Intel Pentium III Xeon processor	\N	\N	4	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	2127	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2268	\N	\N	\N	\N	\N	\N	\N	\N	\N	en|US|iso8859-1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Bios	\N	\N	\N	\N	\N	American Megatrends Inc.	\N	\N	\N	\N	BIOS Date: 01/24/11 11:24:07 Ver: 08.00.15	\N	\N	\N	\N	\N	\N	\N	t	2011-01-24 00:00:00	xxx-xxxxxxxx	\N	\N	080015	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	NEC    - 1001124	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2269	\N	\N	\N	\N	\N	\N	\N	BBK-2C81EDE6156	\N	\N	120	\N	f	\N	AT/AT COMPATIBLE	\N	\N	\N	\N	WORKGROUP	\N	\N	\N	Win32_ComputerSystem	\N	\N	\N	\N	\N	NCR Corporation	\N	NCR Talladega1	\N	\N	BBK-2C81EDE6156	\N	\N	1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	2121367552	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2270	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	Win32_ParallelPort	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	LPT1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2271	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2830	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2830&SUBSYS_28308086&REV_02\\3&11583659&1&E8	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2830	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	4
2272	\N	\N	\N	\N	\N	\N	\N	Default Monitor	\N	\N	\N	\N	\N	\N	\N	DesktopMonitor2	\N	\N	f	\N	\N	\N	\N	Win32_DesktopMonitor	\N	\N	\N	\N	\N	\N	\N	\N	(Standard monitor types)	Default Monitor	Default Monitor	\N	\N	\N	\N	0	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2273	\N	\N	\N	\N	512	\N	\N	ST3160318AS	\N	\N	\N	\N	\N	\N	Disk drive	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	\N	\N	\N	\N	Win32_DiskDrive	\N	\N	\N	\N	\N	(Standard disk drives)	\N	ST3160318AS	\N	\N	\\\\.\\PHYSICALDRIVE0	\N	\N	\N	312576705	\N	\N	\N	\N	\N		152625	\N	\N	\N	\N	\N	\N	152625	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	Fixed\thard disk media	\N	\N	63	4961535	\N	19457	255	\N	\N	\N	4
2274	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2275	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2834	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2834&SUBSYS_28348086&REV_02\\3&11583659&1&D0	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2834	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	4
2276	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Composite Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Composite Device	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2277	\N	\N	\N	\N	\N	Talladega	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Win32_BaseBoard	\N	\N	\N	\N	\N	NCR Corporation	\N		\N	\N	Base Board	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2278	Ethernet 802.3	\N	\N	\N	\N	\N	\N	[00000001] Intel(R) 82566DM Gigabit Network Connection	\N	\N	\N	\N	\N		Intel(R) 82566DM Gigabit Network Connection	\N	f		\N	\N	\N	\N	\N	Win32_NetworkAdapter	\N	135.130.15.128	255.255.255.0	\N	00:1A:D4:17:97:20	Intel	\N	\N	\N	\N	Intel(R) 82566DM Gigabit Network Connection	Local Area Connection	2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2279	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2835	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2835&SUBSYS_28358086&REV_02\\3&11583659&1&D1	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2835	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	4
2280	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	USB Root Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2281	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	128	\N	32	800	4294967296	60	600	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R) GMA 3000	\N	\N	4
2282	\N	\N	\N	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2832	\N	\N	\N	\N	\N	\N	\N	PCI\\VEN_8086&DEV_2832&SUBSYS_28328086&REV_02\\3&11583659&1&EA	\N	\N	\N	\N	\N	\N	\N	Win32_USBController	\N	\N	\N	\N	\N	Intel	\N	\N	\N	\N	Intel(R) ICH8 Family USB Universal Host Controller - 2832	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	16	\N	\N	\N	\N	\N	\N	\N	\N	4
2283	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	Local Fixed Disk	D:	\N	\N	\N	\N	\N	NTFS	72038	Win32_LogicalDisk	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	D:	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	73999	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	MASTER	B8F1BC1B	4
2284	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	Win32_VideoController	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R)  Q965/Q963 Express Chipset Family	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	128	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Intel(R) GMA 3000	\N	\N	4
2285	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	Win32_USBHub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Generic USB Hub	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N		\N	\N	\N	\N	\N		\N	\N	\N	\N	\N	\N	\N	\N	\N	4
2286	\N	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	USB Human Interface Device	\N	\N	\N	\N	\N	\N	\N	\N	Win32_Keyboard	\N	\N	\N	0000040A	\N	\N	\N	\N	\N	\N	Enhanced (101- or 102-key)	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	OK	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	4
\.


--
-- Name: hardware_devices_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hardware_devices_id_seq', 2286, true);


--
-- Data for Name: hotfixes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hotfixes (id, description, fix_comments, hotfix_id, installed_on, numbr, terminal_id) FROM stdin;
1	Security Update for Windows XP (KB2478960)	Update	KB2478960	2013-04-08 00:00:00	\N	1
2	Security Update for Windows XP (KB956844)	Update	KB956844	2013-04-08 00:00:00	\N	1
3	Security Update for Windows XP (KB979687)	Update	KB979687	2013-04-08 00:00:00	\N	1
4	Security Update for Windows XP (KB2544521)	Update	KB2544521	2013-04-08 00:00:00	\N	1
5	Security Update for Windows Media Player (KB954155)		KB954155_WM9	\N	\N	1
6	Security Update for Windows XP (KB974571)	Update	KB974571	2013-04-08 00:00:00	\N	1
7	Security Update for Windows XP (KB956802)	Update	KB956802	2013-04-08 00:00:00	\N	1
8	Security Update for Windows XP (KB2510581)	Update	KB2510581	2013-04-08 00:00:00	\N	1
9	Security Update for Windows XP (KB973869)	Update	KB973869	2013-04-08 00:00:00	\N	1
10	Security Update for Windows XP (KB982132)	Update	KB982132	2013-04-08 00:00:00	\N	1
11	Hotfix for Windows XP (KB2779562)	Update	KB2779562	2013-01-12 00:00:00	\N	1
12	Update for Windows Internet Explorer 8 (KB2598845)	Update	KB2598845-IE8	2013-04-08 00:00:00	\N	1
13	Security Update for Windows XP (KB2655992)	Update	KB2655992	2013-04-08 00:00:00	\N	1
14	Security Update for Windows XP (KB2585542)	Update	KB2585542	2013-04-08 00:00:00	\N	1
15	Security Update for Windows XP (KB2707511)	Update	KB2707511	2013-04-08 00:00:00	\N	1
16	Security Update for Windows XP (KB2387149)	Update	KB2387149	2013-04-08 00:00:00	\N	1
17	Security Update for Windows XP (KB2508429)	Update	KB2508429	2013-04-08 00:00:00	\N	1
18	Security Update for Windows XP (KB979482)	Update	KB979482	2013-04-08 00:00:00	\N	1
19	Security Update for Windows XP (KB977914)	Update	KB977914	2013-04-08 00:00:00	\N	1
20	Security Update for Windows XP (KB2478971)	Update	KB2478971	2013-04-08 00:00:00	\N	1
21	Security Update for Windows XP (KB923561)	Update	KB923561	2013-04-08 00:00:00	\N	1
22	Security Update for Windows XP (KB982665)	Update	KB982665	2013-04-08 00:00:00	\N	1
23	Security Update for Windows XP (KB978338)	Update	KB978338	2013-04-08 00:00:00	\N	1
24	Hotfix for Windows XP (KB954550-v5)	Update	KB954550-v5	2013-04-01 00:00:00	\N	1
25	Security Update for Windows XP (KB2727528)	Update	KB2727528	2013-01-12 00:00:00	\N	1
26	Security Update for Windows XP (KB2440591)	Update	KB2440591	2013-04-08 00:00:00	\N	1
27	Security Update for Windows Internet Explorer 8 (KB2618444)	Update	KB2618444-IE8	2013-04-08 00:00:00	\N	1
28	Update for Windows XP (KB971029)	Update	KB971029	2013-04-08 00:00:00	\N	1
29	Security Update for Windows XP (KB981322)	Update	KB981322	2013-04-08 00:00:00	\N	1
30	Security Update for Windows XP (KB2719985)	Update	KB2719985	2013-04-08 00:00:00	\N	1
31	Security Update for Windows XP (KB956572)	Update	KB956572	2013-04-08 00:00:00	\N	1
32	Security Update for Windows XP (KB974112)	Update	KB974112	2013-04-08 00:00:00	\N	1
33	Security Update for Windows XP (KB2757638)	Update	KB2757638	2013-11-01 00:00:00	\N	1
34	Security Update for Windows XP (KB2753842)	Update	KB2753842	2013-01-12 00:00:00	\N	1
35	Security Update for Windows XP (KB971657)	Update	KB971657	2013-04-08 00:00:00	\N	1
36	Security Update for Windows Internet Explorer 8 (KB2510531)	Update	KB2510531-IE8	2013-04-08 00:00:00	\N	1
37	Update for Windows XP (KB2661254-v2)	Update	KB2661254-v2	2013-01-12 00:00:00	\N	1
38	Security Update for Windows XP (KB960859)	Update	KB960859	2013-04-08 00:00:00	\N	1
39	Security Update for Windows XP (KB2724197)	Update	KB2724197	2013-01-12 00:00:00	\N	1
40	Security Update for Windows XP (KB950974)	Update	KB950974	2013-04-08 00:00:00	\N	1
41	Security Update for Windows XP (KB2712808)	Update	KB2712808	2013-04-08 00:00:00	\N	1
42	Update for Windows XP (KB951978)	Update	KB951978	2013-04-08 00:00:00	\N	1
43	Security Update for Windows XP (KB2698365)	Update	KB2698365	2013-04-08 00:00:00	\N	1
44	Security Update for Windows XP (KB952954)	Update	KB952954	2013-04-08 00:00:00	\N	1
45	Security Update for Windows XP (KB950762)	Update	KB950762	2013-04-08 00:00:00	\N	1
46	Hotfix for Windows XP (KB976002-v5)	Update	KB976002-v5	2013-05-12 00:00:00	\N	1
47	Security Update for Windows XP (KB946648)	Update	KB946648	2013-04-08 00:00:00	\N	1
48	Security Update for Windows XP (KB960803)	Update	KB960803	2013-04-08 00:00:00	\N	1
49	Hotfix for Windows XP (KB961118)	Update	KB961118	2013-09-01 00:00:00	\N	1
50	Security Update for Windows XP (KB975560)	Update	KB975560	2013-04-08 00:00:00	\N	1
51	Windows XP Service Pack 3	Service Pack	KB936929	2013-04-08 00:00:00	\N	1
52	Security Update for Windows Media Player (KB975558)		KB975558_WM8	\N	\N	1
53	Security Update for Windows XP (KB959426)	Update	KB959426	2013-04-08 00:00:00	\N	1
54	Security Update for Windows XP (KB2347290)	Update	KB2347290	2013-04-08 00:00:00	\N	1
55	Security Update for Windows XP (KB2695962)	Update	KB2695962	2013-04-08 00:00:00	\N	1
56	Security Update for Windows XP (KB2753842-v2)	Update	KB2753842-v2	2013-12-12 00:00:00	\N	1
57	Update for Windows XP (KB2467659)	Update	KB2467659	2013-04-08 00:00:00	\N	1
58	Security Update for Windows XP (KB2506212)	Update	KB2506212	2013-04-08 00:00:00	\N	1
59	Security Update for Windows XP (KB2584146)	Update	KB2584146	2013-04-08 00:00:00	\N	1
60	Security Update for Windows XP (KB2659262)	Update	KB2659262	2013-04-08 00:00:00	\N	1
61	Update for Windows XP (KB955759)	Update	KB955759	2013-01-12 00:00:00	\N	1
62	Security Update for Windows XP (KB2536276-v2)	Update	KB2536276-v2	2013-04-08 00:00:00	\N	1
63	Security Update for Windows XP (KB2731847)	Update	KB2731847	2013-04-08 00:00:00	\N	1
64	Security Update for Windows XP (KB979309)	Update	KB979309	2013-04-08 00:00:00	\N	1
65	Security Update for Windows XP (KB975713)	Update	KB975713	2013-04-08 00:00:00	\N	1
66	Security Update for Windows Internet Explorer 8 (KB2799329)	Update	KB2799329-IE8	2014-12-01 00:00:00	\N	1
67	Security Update for Windows XP (KB969059)	Update	KB969059	2013-04-08 00:00:00	\N	1
68	Security Update for Windows XP (KB2598479)	Update	KB2598479	2013-04-08 00:00:00	\N	1
69	Update for Windows XP (KB2345886)	Update	KB2345886	2013-04-08 00:00:00	\N	1
70	Security Update for Windows XP (KB2483185)	Update	KB2483185	2013-04-08 00:00:00	\N	1
71	Security Update for Windows XP (KB981997)	Update	KB981997	2013-04-08 00:00:00	\N	1
72	Security Update for Windows XP (KB973904)	Update	KB973904	2013-04-08 00:00:00	\N	1
73	Update for Windows XP (KB2736233)	Update	KB2736233	2013-01-12 00:00:00	\N	1
74	Security Update for Windows XP (KB972270)	Update	KB972270	2013-04-08 00:00:00	\N	1
75	Security Update for Windows XP (KB970430)	Update	KB970430	2013-04-08 00:00:00	\N	1
76	Security Update for Windows XP (KB977816)	Update	KB977816	2013-04-08 00:00:00	\N	1
77	Security Update for Windows Media Player (KB952069)		KB952069_WM9	\N	\N	1
78	Security Update for Windows XP (KB952004)	Update	KB952004	2013-04-08 00:00:00	\N	1
79	Security Update for Windows Internet Explorer 8 (KB2544521)	Update	KB2544521-IE8	2013-04-08 00:00:00	\N	1
80	Security Update for Windows XP (KB2485663)	Update	KB2485663	2013-04-08 00:00:00	\N	1
81	Security Update for Windows XP (KB2443105)	Update	KB2443105	2013-04-08 00:00:00	\N	1
82	Security Update for Windows XP (KB2229593)	Update	KB2229593	2013-04-08 00:00:00	\N	1
83	Security Update for Windows Internet Explorer 8 (KB2722913)	Update	KB2722913-IE8	2013-04-08 00:00:00	\N	1
84	Security Update for Windows XP (KB951376-v2)	Update	KB951376-v2	2013-04-08 00:00:00	\N	1
85	Security Update for Windows XP (KB2423089)	Update	KB2423089	2013-04-08 00:00:00	\N	1
86	Security Update for Windows XP (KB2676562)	Update	KB2676562	2013-04-08 00:00:00	\N	1
87	Security Update for Windows XP (KB2393802)	Update	KB2393802	2013-04-08 00:00:00	\N	1
88	Security Update for Windows XP (KB2624667)	Update	KB2624667	2013-04-08 00:00:00	\N	1
89	Security Update for Windows Media Player (KB973540)		KB973540_WM9	\N	\N	1
90	Update for Windows XP (KB2718704)	Update	KB2718704	2013-04-08 00:00:00	\N	1
91	Security Update for Windows XP (KB956744)	Update	KB956744	2013-04-08 00:00:00	\N	1
92	Security Update for Windows XP (KB975025)	Update	KB975025	2013-04-08 00:00:00	\N	1
93	Security Update for Windows XP (KB2705219)	Update	KB2705219	2013-04-08 00:00:00	\N	1
94	Security Update for Windows XP (KB978542)	Update	KB978542	2013-04-08 00:00:00	\N	1
95	Update for Windows XP (KB898461)	Update	KB898461	2013-04-08 00:00:00	\N	1
96	Security Update for Windows XP (KB2360937)	Update	KB2360937	2013-04-08 00:00:00	\N	1
97	Security Update for Windows XP (KB2507938)	Update	KB2507938	2013-04-08 00:00:00	\N	1
98	Security Update for Windows XP (KB2535512)	Update	KB2535512	2013-04-08 00:00:00	\N	1
99	Security Update for Windows XP (KB2479943)	Update	KB2479943	2013-04-08 00:00:00	\N	1
100	Security Update for Windows XP (KB2620712)	Update	KB2620712	2013-04-08 00:00:00	\N	1
101	Security Update for Windows XP (KB974392)	Update	KB974392	2013-04-08 00:00:00	\N	1
102	Security Update for Windows XP (KB2646524)	Update	KB2646524	2013-04-08 00:00:00	\N	1
103	Security Update for Windows XP (KB2570947)	Update	KB2570947	2013-04-08 00:00:00	\N	1
104	Security Update for Windows XP (KB2619339)	Update	KB2619339	2013-04-08 00:00:00	\N	1
105	Update for Windows XP (KB973815)	Update	KB973815	2013-04-08 00:00:00	\N	1
106	Security Update for Windows XP (KB978706)	Update	KB978706	2013-04-08 00:00:00	\N	1
107	Security Update for Windows XP (KB2544893-v2)	Update	KB2544893-v2	2013-04-08 00:00:00	\N	1
108	Security Update for Windows XP (KB973507)	Update	KB973507	2013-04-08 00:00:00	\N	1
109	Security Update for Windows XP (KB2481109)	Update	KB2481109	2013-04-08 00:00:00	\N	1
110	Security Update for Windows XP (KB2507618)	Update	KB2507618	2013-04-08 00:00:00	\N	1
111	Security Update for Microsoft Windows (KB2564958)	Update	KB2564958	2013-04-08 00:00:00	\N	1
112	Security Update for Windows XP (KB2592799)	Update	KB2592799	2013-04-08 00:00:00	\N	1
113	Security Update for Windows XP (KB2296011)	Update	KB2296011	2013-04-08 00:00:00	\N	1
114	Security Update for Windows XP (KB2723135)	Update	KB2723135	2013-04-08 00:00:00	\N	1
115	Security Update for Windows XP (KB975467)	Update	KB975467	2013-04-08 00:00:00	\N	1
116	Security Update for Windows XP (KB2691442)	Update	KB2691442	2013-04-08 00:00:00	\N	1
117	Update for Windows XP (KB968389)	Update	KB968389	2013-04-08 00:00:00	\N	1
118	Security Update for Windows Media Player (KB978695)		KB978695_WM9	\N	\N	1
119	Security Update for Windows XP (KB2722913)	Update	KB2722913	2013-04-08 00:00:00	\N	1
120	Security Update for Windows XP (KB2509553)	Update	KB2509553	2013-04-08 00:00:00	\N	1
121	Security Update for Windows XP (KB2476490)	Update	KB2476490	2013-04-08 00:00:00	\N	1
122	Security Update for Windows XP (KB2653956)	Update	KB2653956	2013-04-08 00:00:00	\N	1
123	Security Update for Windows XP (KB2661637)	Update	KB2661637	2013-04-08 00:00:00	\N	1
124	Security Update for Windows XP (KB2566454)	Update	KB2566454	2013-04-08 00:00:00	\N	1
125	Security Update for Windows Internet Explorer 8 (KB982381)	Update	KB982381-IE8	2013-04-08 00:00:00	\N	1
126	Security Update for Windows XP (KB2779030)	Update	KB2779030	2013-01-12 00:00:00	\N	1
127	Update for Windows XP (KB2749655)	Update	KB2749655	2013-01-12 00:00:00	\N	1
128	Hotfix for Windows XP (KB952287)	Update	KB952287	2013-04-08 00:00:00	\N	1
129	Security Update for Windows XP (KB2115168)	Update	KB2115168	2013-04-08 00:00:00	\N	1
130	Security Update for Windows XP (KB2419632)	Update	KB2419632	2013-04-08 00:00:00	\N	1
131	Security Update for Windows XP (KB2758857)	Update	KB2758857	2013-01-12 00:00:00	\N	1
132	Security Update for Windows Internet Explorer 8 (KB2761465)	Update	KB2761465-IE8	2013-01-12 00:00:00	\N	1
133	Hotfix for Windows XP (KB2633952)	Update	KB2633952	2013-04-08 00:00:00	\N	1
134	Security Update for Windows XP (KB2770660)	Update	KB2770660	2013-01-12 00:00:00	\N	1
135	Security Update for Windows Media Player (KB2378111)		KB2378111_WM9	\N	\N	1
136	Security Update for Windows XP (KB2686509)	Update	KB2686509	2013-04-08 00:00:00	\N	1
137	Security Update for Windows XP (KB2603381)	Update	KB2603381	2013-04-08 00:00:00	\N	1
138	Security Update for Windows XP (KB974318)	Update	KB974318	2013-04-08 00:00:00	\N	1
139	Security Update for Windows XP (KB2618451)	Update	KB2618451	2013-04-08 00:00:00	\N	1
140	Security Update for Windows XP (KB2631813)	Update	KB2631813	2013-04-08 00:00:00	\N	1
141	Security Update for Windows XP (KB899587)	Update	KB899587	2007-02-10 00:00:00	\N	2
142	Security Update for Windows XP (KB896688)	Update	KB896688	2007-02-10 00:00:00	\N	2
143	Hotfix for Windows XP (KB908673-v2)	Update	KB908673-v2	2012-02-03 00:00:00	\N	2
144	Security Update for Windows XP (KB901214)	Update	KB901214	2007-02-10 00:00:00	\N	2
145	Security Update for Windows XP (KB905414)	Update	KB905414	2007-02-10 00:00:00	\N	2
146	Hotfix for Windows XP (KB920875)	Update	KB920875	2012-02-03 00:00:00	\N	2
147	Windows XP Hotfix - KB873339	Update	KB873339	2007-02-10 00:00:00	\N	2
148	Security Update for Windows XP (KB905749)	Update	KB905749	2007-02-10 00:00:00	\N	2
149	Security Update for Windows XP (KB902400)	Update	KB902400	2007-02-10 00:00:00	\N	2
150	Security Update for Windows XP (KB896423)	Update	KB896423	2007-02-10 00:00:00	\N	2
151	Security Update for Windows XP (KB896428)	Update	KB896428	2007-02-10 00:00:00	\N	2
152	Hotfix for Windows XP (KB924941)	Update	KB924941	2012-02-03 00:00:00	\N	2
153	Security Update for Windows XP (KB901017)	Update	KB901017	2007-02-10 00:00:00	\N	2
154	Windows XP Hotfix - KB885835	Update	KB885835	2007-02-10 00:00:00	\N	2
155	Windows XP Hotfix - KB885836	Update	KB885836	2007-02-10 00:00:00	\N	2
156	Security Update for Windows XP (KB890046)	Update	KB890046	2007-02-10 00:00:00	\N	2
157	Windows XP Hotfix - KB887742	Update	KB887742	2007-02-10 00:00:00	\N	2
158	Security Update for Windows XP (KB893756)	Update	KB893756	2007-02-10 00:00:00	\N	2
159	Security Update for Windows XP (KB896422)	Update	KB896422	2007-02-10 00:00:00	\N	2
160	Security Update for Windows XP (KB899591)	Update	KB899591	2007-02-10 00:00:00	\N	2
161	Security Update for Windows XP (KB904706)	Update	KB904706	2007-02-10 00:00:00	\N	2
162	Windows XP Hotfix - KB888113	Update	KB888113	2007-02-10 00:00:00	\N	2
163	Windows XP Hotfix - KB887472	Update	KB887472	2007-02-10 00:00:00	\N	2
164	Security Update for Windows XP (KB900725)	Update	KB900725	2007-02-10 00:00:00	\N	2
165	Security Update for Windows XP (KB893066)	Update	KB893066	2007-02-10 00:00:00	\N	2
166	Windows XP Hotfix - KB888302	Update	KB888302	2007-02-10 00:00:00	\N	2
167	Security Update for Windows XP (KB899589)	Update	KB899589	2007-02-10 00:00:00	\N	2
168	Windows Installer 3.1 (KB893803)	Update	KB893803v2	2007-02-10 00:00:00	\N	2
169	Windows XP Hotfix - KB886185	Update	KB886185	2007-02-10 00:00:00	\N	2
170	Hotfix for Windows XP (KB914015)	Update	KB914015	2012-02-03 00:00:00	\N	2
171	Windows XP Hotfix - KB885250	Update	KB885250	2007-02-10 00:00:00	\N	2
172	Update for Windows XP (KB898461)	Update	KB898461	2007-02-10 00:00:00	\N	2
173	Security Update for Windows XP (KB896358)	Update	KB896358	2007-02-10 00:00:00	\N	2
174	Hotfix for Windows XP (KB940514)	Update	KB940514	2012-02-03 00:00:00	\N	2
175	Update for Windows XP (KB894391)	Update	KB894391	2007-02-10 00:00:00	\N	2
176	Windows XP Hotfix - KB890859	Update	KB890859	2007-02-10 00:00:00	\N	2
177	Windows XP Hotfix - KB891781	Update	KB891781	2007-02-10 00:00:00	\N	2
736	Update for Windows XP (KB911280)	Update	KB911280	2008-01-10 00:00:00	\N	5
7281	Security Update for Windows XP (KB956844)	Update	KB956844	2011-01-09 00:00:00	\N	4
7282	Security Update for Windows Media Player (KB973540)		KB973540_WM9L	\N	\N	4
7283	Security Update for Windows XP (KB978601)	Update	KB978601	2012-06-11 00:00:00	\N	4
7284	Security Update for Windows XP (KB982381)	Update	KB982381	2012-06-11 00:00:00	\N	4
7285	Security Update for Windows Media Player (KB968816)		KB968816_WM9	\N	\N	4
7286	Security Update for Windows XP (KB960803)	Update	KB960803	2011-01-09 00:00:00	\N	4
7287	Update for Windows XP (KB955759)	Update	KB955759	2012-06-11 00:00:00	\N	4
7288	Security Update for Windows XP (KB979559)	Update	KB979559	2012-06-11 00:00:00	\N	4
7289	Security update for MSXML4 SP2 (KB973688)		Q973688	2010-11-30 00:00:00	\N	4
7290	Security Update for Windows XP (KB974571)	Update	KB974571	2012-06-11 00:00:00	\N	4
645	Security Update for Windows XP (KB912919)	Update	KB912919	2008-01-10 00:00:00	\N	5
646	Security Update for Windows XP (KB929123)	Update	KB929123	2011-01-09 00:00:00	\N	5
647	Security Update for Windows XP (KB952004)	Update	KB952004	2011-01-09 00:00:00	\N	5
648	Security Update for Windows XP (KB911562)	Update	KB911562	2008-01-10 00:00:00	\N	5
649	Security Update for Windows XP (KB943460)	Update	KB943460	2011-01-09 00:00:00	\N	5
650	Security Update for Windows XP (KB950762)	Update	KB950762	2011-01-09 00:00:00	\N	5
651	Security Update for Windows XP (KB917344)	Update	KB917344	2008-01-10 00:00:00	\N	5
652	Security Update for Windows XP (KB923191)	Update	KB923191	2008-01-10 00:00:00	\N	5
653	Security Update for Windows XP (KB924191)	Update	KB924191	2008-01-10 00:00:00	\N	5
654	Hotfix for Windows XP (KB981793)	Update	KB981793	2012-06-11 00:00:00	\N	5
655	Security Update for Windows XP (KB920683)	Update	KB920683	2008-01-10 00:00:00	\N	5
656	Update for Windows XP (KB898461)	Update	KB898461	2008-01-10 00:00:00	\N	5
657	Security Update for Windows XP (KB957097)	Update	KB957097	2011-01-09 00:00:00	\N	5
658	Security Update for Windows XP (KB971032)	Update	KB971032	2011-01-09 00:00:00	\N	5
659	Windows XP Hotfix - KB888302	Update	KB888302	2008-01-10 00:00:00	\N	5
660	Security Update for Windows XP (KB980232)	Update	KB980232	2012-06-11 00:00:00	\N	5
661	Security Update for Windows XP (KB978706)	Update	KB978706	2012-06-11 00:00:00	\N	5
662	Security Update for Windows XP (KB975560)	Update	KB975560	2012-06-11 00:00:00	\N	5
663	Security Update for Windows XP (KB923414)	Update	KB923414	2008-01-10 00:00:00	\N	5
664	Security Update for Windows XP (KB954600)	Update	KB954600	2011-01-09 00:00:00	\N	5
665	Security Update for Windows XP (KB981350)	Update	KB981350	2012-06-11 00:00:00	\N	5
666	Hotfix for Windows XP (KB970653-v3)	Update	KB970653-v3	2011-01-09 00:00:00	\N	5
667	Security Update for Windows XP (KB971633)	Update	KB971633	2011-01-09 00:00:00	\N	5
668	Security Update for Windows XP (KB896424)	Update	KB896424	2008-01-10 00:00:00	\N	5
669	Security Update for Windows Media Player 9 (KB917734)		KB917734_WMP9	\N	\N	5
670	Security Update for Windows XP (KB908519)	Update	KB908519	2008-01-10 00:00:00	\N	5
671	Security Update for Windows XP (KB900725)	Update	KB900725	2008-01-10 00:00:00	\N	5
672	Security Update for Windows XP (KB911927)	Update	KB911927	2008-01-10 00:00:00	\N	5
673	Security Update for Windows XP (KB970238)	Update	KB970238	2011-01-09 00:00:00	\N	5
674	Security Update for Windows XP (KB927802)	Update	KB927802	2011-01-09 00:00:00	\N	5
675	Hotfix for Windows XP (KB908673-v2)	Update	KB908673-v2	2008-09-12 00:00:00	\N	5
676	Security Update for Windows XP (KB970430)	Update	KB970430	2012-06-11 00:00:00	\N	5
677	Security Update for Windows XP (KB973507)	Update	KB973507	2011-01-09 00:00:00	\N	5
678	Security Update for Windows XP (KB975467)	Update	KB975467	2012-06-11 00:00:00	\N	5
679	Security Update for Windows XP (KB924667)	Update	KB924667	2011-01-09 00:00:00	\N	5
680	Security Update for Windows XP (KB973346)	Update	KB973346	2011-01-09 00:00:00	\N	5
681	Hotfix for Windows XP (KB940514)	Update	KB940514	2008-09-12 00:00:00	\N	5
682	Security Update for Windows XP (KB918899)	Update	KB918899	2008-01-10 00:00:00	\N	5
683	Update for Windows XP (KB971737)	Update	KB971737	2012-06-11 00:00:00	\N	5
684	Security Update for Windows XP (KB941569)		KB941569	\N	\N	5
685	Security Update for Windows XP (KB920214)	Update	KB920214	2008-01-10 00:00:00	\N	5
686	Update for Windows XP (KB968389)	Update	KB968389	2011-01-09 00:00:00	\N	5
687	Security Update for Windows XP (KB896358)	Update	KB896358	2008-01-10 00:00:00	\N	5
688	Update for Windows XP (KB910437)	Update	KB910437	2008-01-10 00:00:00	\N	5
689	Security Update for Windows XP (KB973354)	Update	KB973354	2011-01-09 00:00:00	\N	5
690	Security Update for Windows XP (KB928255)	Update	KB928255	2011-01-09 00:00:00	\N	5
691	Security Update for Windows XP (KB969059)	Update	KB969059	2012-06-11 00:00:00	\N	5
692	Windows XP Hotfix - KB886185	Update	KB886185	2008-01-10 00:00:00	\N	5
693	Update for Windows XP (KB900485)	Update	KB900485	2011-01-09 00:00:00	\N	5
694	Security Update for Windows XP (KB918439)	Update	KB918439	2008-01-10 00:00:00	\N	5
695	Update for Windows XP (KB894391)	Update	KB894391	2008-01-10 00:00:00	\N	5
696	Security Update for Windows XP (KB950749)	Update	KB950749	2011-01-09 00:00:00	\N	5
697	Security Update for Windows XP (KB974112)	Update	KB974112	2012-06-11 00:00:00	\N	5
698	Security Update for Windows XP (KB926436)	Update	KB926436	2011-01-09 00:00:00	\N	5
699	Security Update for Windows XP (KB958644)	Update	KB958644	2008-11-12 00:00:00	\N	5
700	Update for Windows XP (KB955759)	Update	KB955759	2012-06-11 00:00:00	\N	5
701	Security Update for Windows XP (KB956572)	Update	KB956572	2011-01-09 00:00:00	\N	5
702	Security Update for Windows XP (KB951748)	Update	KB951748	2011-01-09 00:00:00	\N	5
703	Security Update for Windows XP (KB932168)	Update	KB932168	2011-01-09 00:00:00	\N	5
704	Update for Windows XP (KB973687)	Update	KB973687	2012-06-11 00:00:00	\N	5
705	Security Update for Windows XP (KB905414)	Update	KB905414	2008-01-10 00:00:00	\N	5
706	Windows XP Hotfix - KB891781	Update	KB891781	2008-01-10 00:00:00	\N	5
707	Security Update for Windows XP (KB979559)	Update	KB979559	2012-06-11 00:00:00	\N	5
708	Security Update for Windows XP (KB924496)	Update	KB924496	2008-01-10 00:00:00	\N	5
709	Update for Windows XP (KB967715)	Update	KB967715	2011-01-09 00:00:00	\N	5
710	Security Update for Windows XP (KB950974)	Update	KB950974	2011-01-09 00:00:00	\N	5
711	Security Update for Windows XP (KB978601)	Update	KB978601	2012-06-11 00:00:00	\N	5
712	Security Update for Windows XP (KB893756)	Update	KB893756	2008-01-10 00:00:00	\N	5
713	Security Update for Windows XP (KB914389)	Update	KB914389	2008-01-10 00:00:00	\N	5
714	Security Update for Windows XP (KB959426)	Update	KB959426	2011-01-09 00:00:00	\N	5
715	Security Update for Windows XP (KB974571)	Update	KB974571	2012-06-11 00:00:00	\N	5
716	Security Update for Windows XP (KB2229593)	Update	KB2229593	2012-06-11 00:00:00	\N	5
717	Security Update for Windows XP (KB923561)	Update	KB923561	2011-01-09 00:00:00	\N	5
718	Security Update for Windows Media Player (KB952069)		KB952069_WM9	\N	\N	5
719	Security Update for Windows XP (KB978542)	Update	KB978542	2012-06-11 00:00:00	\N	5
720	Security Update for Windows XP (KB896423)	Update	KB896423	2008-01-10 00:00:00	\N	5
721	Security Update for Windows XP (KB972260)	Update	KB972260	2011-01-09 00:00:00	\N	5
722	Security Update for Windows XP (KB946648)	Update	KB946648	2011-01-09 00:00:00	\N	5
723	Security Update for Windows XP (KB975713)	Update	KB975713	2012-06-11 00:00:00	\N	5
724	Security Update for Windows XP (KB944653)	Update	KB944653	2011-01-09 00:00:00	\N	5
725	Security Update for Windows XP (KB922616)	Update	KB922616	2008-01-10 00:00:00	\N	5
726	Security Update for Windows XP (KB938464-v2)	Update	KB938464-v2	2011-01-09 00:00:00	\N	5
727	Security Update for Windows XP (KB913580)	Update	KB913580	2008-01-10 00:00:00	\N	5
728	Security Update for Windows XP (KB980195)	Update	KB980195	2012-06-11 00:00:00	\N	5
729	Security Update for Windows XP (KB956802)	Update	KB956802	2011-01-09 00:00:00	\N	5
730	Security Update for Windows XP (KB926255)	Update	KB926255	2011-01-09 00:00:00	\N	5
731	Security Update for Windows XP (KB961371-v2)	Update	KB961371-v2	2011-01-09 00:00:00	\N	5
732	Security Update for Windows XP (KB921398)	Update	KB921398	2008-01-10 00:00:00	\N	5
733	Security Update for Windows XP (KB899591)	Update	KB899591	2008-01-10 00:00:00	\N	5
734	Security Update for Windows XP (KB979309)	Update	KB979309	2012-06-11 00:00:00	\N	5
735	Security Update for Windows XP (KB956844)	Update	KB956844	2011-01-09 00:00:00	\N	5
737	Update for Windows XP (KB938828)	Update	KB938828	2011-01-09 00:00:00	\N	5
738	Security Update for Windows XP (KB978037)	Update	KB978037	2012-06-11 00:00:00	\N	5
739	Security Update for Windows XP (KB917422)	Update	KB917422	2008-01-10 00:00:00	\N	5
740	Security Update for Windows XP (KB971657)	Update	KB971657	2011-01-09 00:00:00	\N	5
741	Security Update for Windows XP (KB982381)	Update	KB982381	2012-06-11 00:00:00	\N	5
742	Security Update for Windows XP (KB943055)	Update	KB943055	2011-01-09 00:00:00	\N	5
743	Security Update for Windows Media Player (KB978695)		KB978695_WM9	\N	\N	5
744	Update for Windows XP (KB920872)	Update	KB920872	2011-01-09 00:00:00	\N	5
745	Security Update for Windows XP (KB890046)	Update	KB890046	2008-01-10 00:00:00	\N	5
746	Security Update for Windows XP (KB975561)	Update	KB975561	2012-06-11 00:00:00	\N	5
747	Security Update for Windows XP (KB921883)	Update	KB921883	2008-01-10 00:00:00	\N	5
748	Security Update for Windows XP (KB960803)	Update	KB960803	2011-01-09 00:00:00	\N	5
749	Security Update for Windows XP (KB938127)	Update	KB938127	2011-01-09 00:00:00	\N	5
750	Security Update for Windows XP (KB951376-v2)	Update	KB951376-v2	2011-01-09 00:00:00	\N	5
751	Windows XP Hotfix - KB890859	Update	KB890859	2008-01-10 00:00:00	\N	5
752	Security Update for Windows XP (KB899589)	Update	KB899589	2008-01-10 00:00:00	\N	5
753	Security update for MSXML4 SP2 (KB954430)		Q954430	2009-09-25 00:00:00	\N	5
754	Security Update for Windows XP (KB899587)	Update	KB899587	2008-01-10 00:00:00	\N	5
755	Security Update for Windows XP (KB944338-v2)	Update	KB944338-v2	2011-01-09 00:00:00	\N	5
756	Security Update for Windows XP (KB901214)	Update	KB901214	2008-01-10 00:00:00	\N	5
757	Security Update for Windows XP (KB971468)	Update	KB971468	2012-06-11 00:00:00	\N	5
758	Security Update for Windows XP (KB904706)	Update	KB904706	2008-01-10 00:00:00	\N	5
759	Security Update for Windows XP (KB972270)	Update	KB972270	2012-06-11 00:00:00	\N	5
760	Security Update for Windows XP (KB925486)	Update	KB925486	2008-01-10 00:00:00	\N	5
761	Security Update for Windows XP (KB918118)	Update	KB918118	2011-01-09 00:00:00	\N	5
762	Update for Windows XP (KB922582)	Update	KB922582	2008-01-10 00:00:00	\N	5
763	Security Update for Windows Media Player 6.4 (KB925398)		KB925398_WMP64	\N	\N	5
764	Update for Windows XP (KB916595)	Update	KB916595	2008-01-10 00:00:00	\N	5
765	Security Update for Windows XP (KB956803)	Update	KB956803	2011-01-09 00:00:00	\N	5
766	Security Update for Windows XP (KB919007)	Update	KB919007	2008-01-10 00:00:00	\N	5
767	Security Update for Windows XP (KB968537)	Update	KB968537	2011-01-09 00:00:00	\N	5
768	Hotfix for Windows XP (KB935448)	Update	KB935448	2011-01-09 00:00:00	\N	5
769	Security update for MSXML4 SP2 (KB973688)		Q973688	2010-11-30 00:00:00	\N	5
770	Security Update for Windows XP (KB979482)	Update	KB979482	2012-06-11 00:00:00	\N	5
771	Security Update for Windows XP (KB926247)	Update	KB926247	2011-01-09 00:00:00	\N	5
772	Security Update for Windows XP (KB958687)	Update	KB958687	2011-01-09 00:00:00	\N	5
773	Update for Windows XP (KB936357)	Update	KB936357	2011-01-09 00:00:00	\N	5
774	Security Update for Windows XP (KB914388)	Update	KB914388	2008-01-10 00:00:00	\N	5
775	Security Update for Windows XP (KB980218)	Update	KB980218	2012-06-11 00:00:00	\N	5
776	Security Update for Windows XP (KB951066)	Update	KB951066	2011-01-09 00:00:00	\N	5
777	Windows Installer 3.1 (KB893803)	Update	KB893803v2	2008-01-10 00:00:00	\N	5
778	Hotfix for Windows XP (KB920875)	Update	KB920875	2008-09-12 00:00:00	\N	5
779	Security Update for Windows XP (KB931261)	Update	KB931261	2011-01-09 00:00:00	\N	5
780	Security Update for Windows XP (KB896428)	Update	KB896428	2008-01-10 00:00:00	\N	5
781	Security Update for Windows XP (KB973904)	Update	KB973904	2012-06-11 00:00:00	\N	5
782	Security Update for Windows Media Player (KB973540)		KB973540_WM9L	\N	\N	5
783	Security Update for Windows XP (KB920670)	Update	KB920670	2008-01-10 00:00:00	\N	5
784	Security Update for Windows XP (KB901017)	Update	KB901017	2008-01-10 00:00:00	\N	5
785	Windows XP Hotfix - KB887472	Update	KB887472	2008-01-10 00:00:00	\N	5
786	Security Update for Windows Media Player (KB954155)		KB954155_WM9	\N	\N	5
787	Security Update for Windows XP (KB905749)	Update	KB905749	2008-01-10 00:00:00	\N	5
788	Security Update for Windows XP (KB902400)	Update	KB902400	2008-01-10 00:00:00	\N	5
789	Windows XP Hotfix - KB885836	Update	KB885836	2008-01-10 00:00:00	\N	5
790	Security Update for Windows XP (KB961501)	Update	KB961501	2011-01-09 00:00:00	\N	5
791	Windows XP Hotfix - KB885835	Update	KB885835	2008-01-10 00:00:00	\N	5
792	Security Update for Windows XP (KB977816)	Update	KB977816	2012-06-11 00:00:00	\N	5
793	Hotfix for Windows XP (KB952287)	Update	KB952287	2011-01-09 00:00:00	\N	5
794	Security Update for Windows XP (KB974392)	Update	KB974392	2012-06-11 00:00:00	\N	5
795	Security Update for Windows XP (KB960225)	Update	KB960225	2011-01-09 00:00:00	\N	5
796	Security Update for Windows XP (KB975562)	Update	KB975562	2012-06-11 00:00:00	\N	5
797	Security Update for Windows XP (KB925902)	Update	KB925902	2011-01-09 00:00:00	\N	5
798	Security Update for Windows XP (KB977914)	Update	KB977914	2012-06-11 00:00:00	\N	5
799	Security Update for Windows XP (KB924270)	Update	KB924270	2011-01-09 00:00:00	\N	5
800	Security Update for Windows XP (KB920685)	Update	KB920685	2008-01-10 00:00:00	\N	5
801	Security Update for Windows Media Player (KB968816)		KB968816_WM9	\N	\N	5
802	Update for Windows XP (KB927891)	Update	KB927891	2011-01-09 00:00:00	\N	5
803	Security Update for Windows XP (KB945553)	Update	KB945553	2011-01-09 00:00:00	\N	5
804	Security Update for Windows XP (KB922819)	Update	KB922819	2008-01-10 00:00:00	\N	5
805	Security Update for Windows XP (KB923980)	Update	KB923980	2011-01-09 00:00:00	\N	5
806	Security Update for Windows XP (KB930178)	Update	KB930178	2011-01-09 00:00:00	\N	5
807	Security Update for Windows XP (KB927779)	Update	KB927779	2011-01-09 00:00:00	\N	5
808	Security Update for Windows XP (KB975025)	Update	KB975025	2012-06-11 00:00:00	\N	5
809	Security Update for Windows XP (KB946026)	Update	KB946026	2011-01-09 00:00:00	\N	5
810	Security Update for Windows XP (KB979683)	Update	KB979683	2012-06-11 00:00:00	\N	5
811	Security Update for Windows XP (KB978338)	Update	KB978338	2012-06-11 00:00:00	\N	5
812	Hotfix for Windows XP (KB924941)	Update	KB924941	2008-09-12 00:00:00	\N	5
813	Security Update for Windows XP (KB974318)	Update	KB974318	2012-06-11 00:00:00	\N	5
814	Update for Windows XP (KB930916)	Update	KB930916	2011-01-09 00:00:00	\N	5
815	Security Update for Windows XP (KB958869)	Update	KB958869	2012-06-11 00:00:00	\N	5
816	Hotfix for Windows XP (KB914015)	Update	KB914015	2008-09-12 00:00:00	\N	5
817	Security Update for Windows XP (KB917953)	Update	KB917953	2008-01-10 00:00:00	\N	5
818	Security Update for Windows XP (KB920213)	Update	KB920213	2011-01-09 00:00:00	\N	5
819	Security Update for Windows XP (KB960859)	Update	KB960859	2011-01-09 00:00:00	\N	5
820	Windows XP Hotfix - KB873339	Update	KB873339	2008-01-10 00:00:00	\N	5
821	Security Update for Windows XP (KB973869)	Update	KB973869	2011-01-09 00:00:00	\N	5
822	Security Update for Windows XP (KB928843)	Update	KB928843	2011-01-09 00:00:00	\N	5
823	Update for Windows XP (KB973815)	Update	KB973815	2011-01-09 00:00:00	\N	5
824	Security Update for Windows XP (KB971961)	Update	KB971961	2011-01-09 00:00:00	\N	5
825	Security Update for Windows XP (KB955069)	Update	KB955069	2011-01-09 00:00:00	\N	5
826	Security Update for Windows XP (KB958470)	Update	KB958470	2011-01-09 00:00:00	\N	5
827	Security Update for Windows XP (KB911567)	Update	KB911567	2008-01-10 00:00:00	\N	5
828	Update for Windows XP (KB908531)	Update	KB908531	2008-01-10 00:00:00	\N	5
829	Windows XP Hotfix - KB883667	Update	KB883667	2008-11-12 00:00:00	\N	5
830	Security Update for Windows XP (KB971557)	Update	KB971557	2011-01-09 00:00:00	\N	5
831	Security Update for Windows XP (KB952954)	Update	KB952954	2011-01-09 00:00:00	\N	5
838	Windows Media Player Hotfix [See Q828026 for more information]	Update	Q828026	2006-07-05 00:00:00	\N	7
839	Windows XP Service Pack 3	Service Pack	KB936929	2009-01-04 00:00:00	\N	7
840	Windows XP Service Pack 2	Service Pack	KB811113	2008-03-04 00:00:00	\N	7
841	Windows Media Player Hotfix [See Q828026 for more information]		Q828026	\N	\N	7
842	Windows Blaster Worm Removal Tool (KB833330)	Update	KB833330	2006-04-05 00:00:00	\N	7
843	Security Update for Windows Media Player 9 (KB917734)		KB917734_WMP9	\N	\N	7
7291	Security Update for Windows XP (KB975713)	Update	KB975713	2012-06-11 00:00:00	\N	4
7292	Security Update for Windows XP (KB951066)	Update	KB951066	2011-01-09 00:00:00	\N	4
7293	Security Update for Windows XP (KB960859)	Update	KB960859	2011-01-09 00:00:00	\N	4
7294	Security Update for Windows XP (KB978706)	Update	KB978706	2012-06-11 00:00:00	\N	4
7295	Security Update for Windows XP (KB973354)	Update	KB973354	2011-01-09 00:00:00	\N	4
7296	Security Update for Windows XP (KB959426)	Update	KB959426	2011-01-09 00:00:00	\N	4
7297	Security Update for Windows XP (KB923561)	Update	KB923561	2011-01-09 00:00:00	\N	4
7298	Security Update for Windows XP (KB974318)	Update	KB974318	2012-06-11 00:00:00	\N	4
7299	Security Update for Windows XP (KB946648)	Update	KB946648	2011-01-09 00:00:00	\N	4
7300	Security Update for Windows XP (KB977914)	Update	KB977914	2012-06-11 00:00:00	\N	4
7301	Security Update for Windows XP (KB958644)	Update	KB958644	2008-11-12 00:00:00	\N	4
7302	Security Update for Windows XP (KB952954)	Update	KB952954	2011-01-09 00:00:00	\N	4
7303	Hotfix for Windows XP (KB952287)	Update	KB952287	2011-01-09 00:00:00	\N	4
7304	Update for Windows XP (KB2661254-v2)	Update	KB2661254-v2	2013-11-07 00:00:00	\N	4
7305	Security Update for Windows XP (KB974392)	Update	KB974392	2012-06-11 00:00:00	\N	4
7306	Security update for MSXML4 SP2 (KB954430)		Q954430	2009-09-25 00:00:00	\N	4
7307	Security Update for Windows XP (KB977816)	Update	KB977816	2012-06-11 00:00:00	\N	4
7308	Security Update for Windows XP (KB951376-v2)	Update	KB951376-v2	2011-01-09 00:00:00	\N	4
7309	Security Update for Windows XP (KB980218)	Update	KB980218	2012-06-11 00:00:00	\N	4
7310	Security Update for Windows XP (KB961371-v2)	Update	KB961371-v2	2011-01-09 00:00:00	\N	4
7311	Security Update for Windows XP (KB954600)	Update	KB954600	2011-01-09 00:00:00	\N	4
7312	Security Update for Windows XP (KB958869)	Update	KB958869	2012-06-11 00:00:00	\N	4
7313	Update for Windows XP (KB968389)	Update	KB968389	2011-01-09 00:00:00	\N	4
7314	Security Update for Windows XP (KB978542)	Update	KB978542	2012-06-11 00:00:00	\N	4
7315	Security Update for Windows XP (KB975561)	Update	KB975561	2012-06-11 00:00:00	\N	4
7316	Security Update for Windows XP (KB975025)	Update	KB975025	2012-06-11 00:00:00	\N	4
7317	Security Update for Windows XP (KB975467)	Update	KB975467	2012-06-11 00:00:00	\N	4
7318	Update for Windows XP (KB967715)	Update	KB967715	2011-01-09 00:00:00	\N	4
7319	Windows XP Service Pack 3	Service Pack	KB936929	2013-11-07 00:00:00	\N	4
7320	Security Update for Windows XP (KB2229593)	Update	KB2229593	2012-06-11 00:00:00	\N	4
7321	Security Update for Windows XP (KB979683)	Update	KB979683	2012-06-11 00:00:00	\N	4
7322	Update for Windows XP (KB973687)	Update	KB973687	2012-06-11 00:00:00	\N	4
7323	Security Update for Windows XP (KB950762)	Update	KB950762	2011-01-09 00:00:00	\N	4
7324	Security Update for Windows XP (KB956802)	Update	KB956802	2011-01-09 00:00:00	\N	4
7325	Security Update for Windows XP (KB956803)	Update	KB956803	2011-01-09 00:00:00	\N	4
7326	Security Update for Windows XP (KB970430)	Update	KB970430	2012-06-11 00:00:00	\N	4
7327	Security Update for Windows XP (KB971468)	Update	KB971468	2012-06-11 00:00:00	\N	4
7328	Security Update for Windows XP (KB958687)	Update	KB958687	2011-01-09 00:00:00	\N	4
7329	Security Update for Windows XP (KB973346)	Update	KB973346	2011-01-09 00:00:00	\N	4
7330	Update for Windows XP (KB971737)	Update	KB971737	2012-06-11 00:00:00	\N	4
7331	Security Update for Windows XP (KB952004)	Update	KB952004	2011-01-09 00:00:00	\N	4
7332	Security Update for Windows XP (KB956572)	Update	KB956572	2011-01-09 00:00:00	\N	4
7333	Security Update for Windows XP (KB961501)	Update	KB961501	2011-01-09 00:00:00	\N	4
7334	Security Update for Windows XP (KB974112)	Update	KB974112	2012-06-11 00:00:00	\N	4
7335	Security Update for Windows Media Player 6.4 (KB925398)		KB925398_WMP64	\N	\N	4
7336	Security Update for Windows XP (KB980195)	Update	KB980195	2012-06-11 00:00:00	\N	4
7337	Hotfix for Windows XP (KB970653-v3)	Update	KB970653-v3	2011-01-09 00:00:00	\N	4
7338	Security Update for Windows XP (KB950974)	Update	KB950974	2011-01-09 00:00:00	\N	4
7339	Security Update for Windows XP (KB979482)	Update	KB979482	2012-06-11 00:00:00	\N	4
7340	Security Update for Windows XP (KB973507)	Update	KB973507	2011-01-09 00:00:00	\N	4
7341	Security Update for Windows XP (KB955069)	Update	KB955069	2011-01-09 00:00:00	\N	4
7342	Security Update for Windows XP (KB957097)	Update	KB957097	2011-01-09 00:00:00	\N	4
7343	Security Update for Windows XP (KB971633)	Update	KB971633	2011-01-09 00:00:00	\N	4
7344	Security Update for Windows Media Player 9 (KB917734)		KB917734_WMP9	\N	\N	4
7345	Security Update for Windows XP (KB941569)		KB941569	\N	\N	4
7346	Security Update for Windows XP (KB973869)	Update	KB973869	2011-01-09 00:00:00	\N	4
7347	Security Update for Windows XP (KB972270)	Update	KB972270	2012-06-11 00:00:00	\N	4
7348	Hotfix for Windows XP (KB981793)	Update	KB981793	2012-06-11 00:00:00	\N	4
7349	Security Update for Windows XP (KB971557)	Update	KB971557	2011-01-09 00:00:00	\N	4
7350	Security Update for Windows XP (KB969059)	Update	KB969059	2012-06-11 00:00:00	\N	4
7351	Security Update for Windows XP (KB971657)	Update	KB971657	2011-01-09 00:00:00	\N	4
7352	Security Update for Windows XP (KB980232)	Update	KB980232	2012-06-11 00:00:00	\N	4
7353	Security Update for Windows XP (KB979309)	Update	KB979309	2012-06-11 00:00:00	\N	4
7354	Update for Windows XP (KB973815)	Update	KB973815	2011-01-09 00:00:00	\N	4
7355	Security Update for Windows XP (KB968537)	Update	KB968537	2011-01-09 00:00:00	\N	4
7356	Security Update for Windows XP (KB972260)	Update	KB972260	2011-01-09 00:00:00	\N	4
7357	Security Update for Windows XP (KB938464-v2)	Update	KB938464-v2	2011-01-09 00:00:00	\N	4
7358	Security Update for Windows Media Player (KB954155)		KB954155_WM9	\N	\N	4
7359	Security Update for Windows XP (KB975562)	Update	KB975562	2012-06-11 00:00:00	\N	4
7360	Security Update for Windows XP (KB960225)	Update	KB960225	2011-01-09 00:00:00	\N	4
7361	Security Update for Windows XP (KB970238)	Update	KB970238	2011-01-09 00:00:00	\N	4
7362	Security Update for Windows XP (KB973904)	Update	KB973904	2012-06-11 00:00:00	\N	4
7363	Security Update for Windows XP (KB951748)	Update	KB951748	2011-01-09 00:00:00	\N	4
7364	Security Update for Windows Media Player (KB978695)		KB978695_WM9	\N	\N	4
7365	Security Update for Windows Media Player (KB952069)		KB952069_WM9	\N	\N	4
7366	Security Update for Windows XP (KB978338)	Update	KB978338	2012-06-11 00:00:00	\N	4
7367	Security Update for Windows XP (KB975560)	Update	KB975560	2012-06-11 00:00:00	\N	4
7368	Security Update for Windows XP (KB978037)	Update	KB978037	2012-06-11 00:00:00	\N	4
\.


--
-- Name: hotfixes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hotfixes_id_seq', 7368, true);


--
-- Data for Name: internet_explorers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY internet_explorers (id, major_version, minor_version, build_version, revision_version, remaining_version) FROM stdin;
1	8	0	6001	18702	\N
2	6	0	2900	2180	\N
4	6	0	2900	5512	\N
\.


--
-- Name: internet_explorers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('internet_explorers_id_seq', 4, true);


--
-- Data for Name: logical_cash_units; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY logical_cash_units (id, currency_id, maximum, minimum, name, type, unit_id, vals, xfs_component_id) FROM stdin;
\.


--
-- Name: logical_cash_units_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('logical_cash_units_id_seq', 1, false);


--
-- Data for Name: operating_systems; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY operating_systems (id, os_language, os_type, build_version, major_version, manufacturer, minor_version, name, organization, remaining_version, revision_version, serial_number, service_pack_build_version, service_pack_major_version, service_pack_minor_version, service_pack_remaining_version, service_pack_revision_version) FROM stdin;
1	1033	18	2600	5	Microsoft Corporation	1	Microsoft Windows XP Professional|C:\\WINDOWS|\\Device\\Harddisk0\\Partition1	CAJERO	\N	\N	76487-642-0974107-23340	\N	3	0	\N	\N
2	1033	18	2600	5	Microsoft Corporation	1	Microsoft Windows XP Professional|C:\\WINDOWS|\\Device\\Harddisk0\\Partition1	KUTXA	\N	\N	76487-OEM-0011903-02810	\N	2	0	\N	\N
3	1033	18	2600	5	Microsoft Corporation	1	Microsoft Windows XP Professional|C:\\WINDOWS|\\Device\\Harddisk0\\Partition1	BBK	\N	\N	76487-640-0334963-23620	\N	2	0	\N	\N
4	1033	18	2600	5	Microsoft Corporation	1	Microsoft Windows XP Professional|C:\\WINDOWS|\\Device\\Harddisk0\\Partition1	BBK	\N	\N	76487-640-0334963-23693	\N	2	0	\N	\N
6	1033	18	2600	5	Microsoft Corporation	1	Microsoft Windows XP Professional|C:\\WINDOWS|\\Device\\Harddisk0\\Partition1	Caja Madrid	\N	\N	55274-640-0825742-23239	\N	3	0	\N	\N
8	1033	18	2600	5	Microsoft Corporation	1	Microsoft Windows XP Professional|C:\\WINDOWS|\\Device\\Harddisk0\\Partition1	BBK	\N	\N	76487-640-0334963-23878	\N	3	0	\N	\N
7	1033	18	2600	5	Microsoft Corporation	\N	Microsoft Windows XP Professional|C:\\WIN|\\Device\\Harddisk0\\Partition1	BANCAJA	\N	\N	76487-640-3596964-23241	\N	2	0	\N	\N
\.


--
-- Name: operating_systems_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('operating_systems_id_seq', 8, true);


--
-- Data for Name: physical_cash_units; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY physical_cash_units (id, hardware_sensor, maximum, name, unit_id, logical_cash_unit_id) FROM stdin;
\.


--
-- Name: physical_cash_units_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('physical_cash_units_id_seq', 1, false);


--
-- Data for Name: queries; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY queries (id, feat_sw_cb1, feat_sw_cb2, feat_sw_cb3, feat_sw_cb4, feat_sw_cb5, feat_sw_c11, feat_sw_c12, feat_sw_c21, feat_sw_c22, feat_sw_c31, feat_sw_c32, feat_sw_c41, feat_sw_c42, feat_sw_c51, feat_sw_c52, feat_sw_f1, feat_sw_f2, feat_sw_f3, feat_sw_f4, feat_sw_f5, financial_dev_cb1, financial_dev_cb2, financial_dev_cb3, financial_dev_cb4, financial_dev_cb5, financial_dev_c11, financial_dev_c12, financial_dev_c21, financial_dev_c22, financial_dev_c31, financial_dev_c32, financial_dev_c41, financial_dev_c42, financial_dev_c51, financial_dev_c52, financial_dev_f1, financial_dev_f2, financial_dev_f3, financial_dev_f4, financial_dev_f5, hw_device_cb1, hw_device_cb2, hw_device_cb3, hw_device_cb4, hw_device_cb5, hw_device_c11, hw_device_c12, hw_device_c13, hw_device_c21, hw_device_c22, hw_device_c23, hw_device_c31, hw_device_c32, hw_device_c33, hw_device_c41, hw_device_c42, hw_device_c43, hw_device_c51, hw_device_c52, hw_device_c53, hw_device_f1, hw_device_f2, hw_device_f3, hw_device_f4, hw_device_f5, hotfix_cb1, hotfix_cb2, hotfix_cb3, hotfix_cb4, hotfix_cb5, hotfix_c11, hotfix_c12, hotfix_c21, hotfix_c22, hotfix_c31, hotfix_c32, hotfix_c41, hotfix_c42, hotfix_c51, hotfix_c52, hotfix_f1, hotfix_f2, hotfix_f3, hotfix_f4, hotfix_f5, ie_cb1, ie_cb2, ie_c11, ie_c12, ie_c21, ie_c22, ie_f1, ie_f2, query_name, op_system_cb1, op_system_cb2, op_system_cb3, op_system_cb4, op_system_cb5, op_system_c11, op_system_c12, op_system_c21, op_system_c22, op_system_c31, op_system_c32, op_system_c41, op_system_c42, op_system_c51, op_system_c52, op_system_f1, op_system_f2, op_system_f3, op_system_f4, op_system_f5, software_cb1, software_cb2, software_cb3, software_cb4, software_cb5, software_c11, software_c12, software_c21, software_c22, software_c31, software_c32, software_c41, software_c42, software_c51, software_c52, software_f1, software_f2, software_f3, software_f4, software_f5, terminal_cb1, terminal_cb2, terminal_cb3, terminal_cb4, terminal_cb5, terminal_c11, terminal_c12, terminal_c21, terminal_c22, terminal_c31, terminal_c32, terminal_c41, terminal_c42, terminal_c51, terminal_c52, terminal_f1, terminal_f2, terminal_f3, terminal_f4, terminal_f5, xfs_sw_cb1, xfs_sw_cb2, xfs_sw_cb3, xfs_sw_cb4, xfs_sw_cb5, xfs_sw_c11, xfs_sw_c12, xfs_sw_c21, xfs_sw_c22, xfs_sw_c31, xfs_sw_c32, xfs_sw_c41, xfs_sw_c42, xfs_sw_c51, xfs_sw_c52, xfs_sw_f1, xfs_sw_f2, xfs_sw_f3, xfs_sw_f4, xfs_sw_f5, user_id) FROM stdin;
4	f	f	f	f	f																f	t	t	t	f	name	contains	name	contains	name	contains	name	contains			USBEPP2	RS232PageTurnPassbook	PcThermal	SdcInfraRed		f	t	f	f	f	Win32_Processor	name	contains	Win32_NetworkAdapter	name	contains										Duo	Globetek				f	f	f	f	f																f	f							Windows7 Ready	t	f	f	f	f	name	contains									Windows 7					f	f	f	f	f																t	f	f	f	f	productClass	contains									56					f	f	f	f	f																1
8	f	f	f	f	f																f	f	f	f	f																f	f	f	f	f	Win32_Processor	manufacturer	contains	Win32_Processor	currentClockSpeed	greater										Intel	1000				f	f	f	f	f																f	f							test	f	f	f	f	f																f	f	f	f	f																f	f	f	f	f	geographicAddress	contains									Madrid					f	f	f	f	f	name	contains									EDEP					1
15	f	f	f	f	f																f	f	f	f	f																f	f	f	f	f	Win32_Processor	currentClockSpeed	greater													1000					f	f	f	f	f																f	f							asdasda	f	f	f	f	f																f	f	f	f	f																f	f	f	f	f	terminalVendor	contains									NCR					f	f	f	f	f	name	contains									EDEP					1
\.


--
-- Name: queries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('queries_id_seq', 15, true);


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY roles (id, name, manageable) FROM stdin;
1	SUPERADMIN	f
2	ADMIN	t
3	DATA_MANAGER	t
4	GUEST	t
\.


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('roles_id_seq', 4, true);


--
-- Data for Name: scheduled_updates; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY scheduled_updates (id, hours, minutes, week_day, month_day) FROM stdin;
21	0	0	\N	1
22	14	30	\N	13
23	23	59	1	\N
\.


--
-- Name: scheduled_updates_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('scheduled_updates_id_seq', 23, true);


--
-- Data for Name: software; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY software (id, caption, description, language, local_package, package_name, product_id, identifying_number, install_date, name, vendor, major_version, minor_version, build_version, revision_version, sw_type, remaining_version) FROM stdin;
1	Java(TM) 7 Update 3	Java(TM) 7 Update 3					{26A24AE4-039D-4CA4-87B4-2F83217003FF}	2012-12-11 00:00:00	Java(TM) 7 Update 3	Oracle	7	0	30	\N	Gen	\N
2	Java Auto Updater	Java Auto Updater					{4A03706F-666A-4037-7777-5F2748764D10}	2012-12-11 00:00:00	Java Auto Updater	Sun Microsystems, Inc.	2	1	6	0	Gen	\N
3	WebFldrs XP	WebFldrs XP					{350C97B0-3D7C-4EE8-BAA9-00BCB3D54227}	2012-08-16 00:00:00	WebFldrs XP	Microsoft Corporation	9	50	7523	\N	Gen	\N
4	Java(TM) SE Development Kit 7 Update 3	Java(TM) SE Development Kit 7 Update 3					{32A3A4F4-B792-11D6-A78A-00B0D0170030}	2012-12-11 00:00:00	Java(TM) SE Development Kit 7 Update 3	Oracle	1	7	0	30	Gen	\N
5	Microsoft Security Client	Microsoft Security Client					{98EABC7F-B1A1-43A5-B505-5B4EC3908DCD}	2012-12-12 00:00:00	Microsoft Security Client	Microsoft Corporation	4	1	522	0	Gen	\N
6	Symantec Ghost	Symantec Ghost					{DC41766A-FAB3-4363-0883-6E7E363F1088}	2013-01-23 00:00:00	Symantec Ghost	Symantec	75	0	335	\N	Gen	\N
7	Microsoft .NET Framework 3.5 SP1	Microsoft .NET Framework 3.5 SP1					{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}	2013-01-11 00:00:00	Microsoft .NET Framework 3.5 SP1	Microsoft Corporation	3	5	30729	\N	Gen	\N
8	Microsoft .NET Framework 3.0 Service Pack 2	Microsoft .NET Framework 3.0 Service Pack 2					{A3051CD0-2F64-3813-A88D-B8DCCDE8F8C7}	2013-01-11 00:00:00	Microsoft .NET Framework 3.0 Service Pack 2	Microsoft Corporation	3	2	30729	\N	Gen	\N
9	SdcCurrencyDispenser	SdcCurrencyDispenser					{2AD76841-1A97-4c9a-B285-350A248723C9}	2013-02-08 00:00:00	SdcCurrencyDispenser	NCR	93	4	0	2	Feat	\N
10	JavaFX 2.0.3 SDK	JavaFX 2.0.3 SDK					{2222706F-666A-4037-7777-203328764D10}	2012-12-11 00:00:00	JavaFX 2.0.3 SDK	Oracle Corporation	2	0	3	\N	Gen	\N
11	VMware Tools	VMware Tools					{FE2F6A2C-196E-4210-9C04-2B1BC21F07EF}	2012-08-16 00:00:00	VMware Tools	VMware, Inc.	8	4	5	14951	Gen	\N
12	Microsoft .NET Framework 2.0 Service Pack 2	Microsoft .NET Framework 2.0 Service Pack 2					{C09FB3CD-3D0C-3F2D-899A-6A1D67F2073F}	2013-01-11 00:00:00	Microsoft .NET Framework 2.0 Service Pack 2	Microsoft Corporation	2	2	30729	\N	Gen	\N
13	JavaFX 2.0.3	JavaFX 2.0.3					{1111706F-666A-4037-7777-203328764D10}	2012-12-11 00:00:00	JavaFX 2.0.3	Oracle Corporation	2	0	3	\N	Gen	\N
14	XFS CDM Service Provider	XFS CDM Service Provider					{8342613E-EA89-409f-BE1F-46D5F4837C57}	2013-02-08 00:00:00	XFS CDM Service Provider	NCR	3	0	0	8	XFS	\N
15	Microsoft Application Error Reporting	Microsoft Application Error Reporting					{95120000-00B9-0409-0000-0000000FF1CE}	2012-12-12 00:00:00	Microsoft Application Error Reporting	Microsoft Corporation	12	0	6012	5000	Gen	\N
16	Vodafone Mobile Broadband Lite	Vodafone Mobile Broadband Lite					{6C29152D-3FF9-43B2-84E4-9B35FC0BF5C2}	2012-12-26 00:00:00	Vodafone Mobile Broadband Lite	Vodafone	10	0	201	23143	Gen	\N
17	Microsoft Office Word MUI (Spanish) 2007	Microsoft Office Word MUI (Spanish) 2007					{90120000-001B-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Word MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
18	BPTRSP	BPTRSP					{30A2AD89-6D19-4DAF-AB11-9C51C2ABCA54}	2012-11-06 00:00:00	BPTRSP	NCR Corporation	91	3	303	\N	Feat	\N
19	Microsoft Office Proof (French) 2007	Microsoft Office Proof (French) 2007					{90120000-001F-040C-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proof (French) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
20	TouchScreens	TouchScreens					{979B47E1-5E05-4C05-A297-C33C1101838B}	2012-03-02 00:00:00	TouchScreens	NCR	3	0	0	\N	Feat	\N
21	USB2DBarcodeReader	USB2DBarcodeReader					{B764E8D8-F84E-4100-A660-3985BA587CEC}	2012-11-06 00:00:00	USB2DBarcodeReader	NCR APTRA	1	0	0	\N	Feat	\N
22	SdcBape	SdcBape					{9EAF8560-58B2-4d11-86EF-0ADA70671B7F}	2012-03-02 00:00:00	SdcBape	NCR	5	0	1	\N	Feat	\N
23	Exception Handling	Exception Handling					{F23108AB-C6CD-11D5-9861-00D0B759864F}	2012-03-02 00:00:00	Exception Handling	NCR	3	0	0	\N	Feat	\N
24	DevMan	DevMan					{D10D20DF-FB1F-434E-B385-0BA065EC7B61}	2012-03-02 00:00:00	DevMan	NCR	1	0	0	\N	Feat	\N
25	Microsoft Office Proof (Catalan) 2007	Microsoft Office Proof (Catalan) 2007					{90120000-001F-0403-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proof (Catalan) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
26	Microsoft Office OneNote MUI (Spanish) 2007	Microsoft Office OneNote MUI (Spanish) 2007					{90120000-00A1-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office OneNote MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
27	Microsoft Office Proof (Portuguese (Brazil)) 2007	Microsoft Office Proof (Portuguese (Brazil)) 2007					{90120000-001F-0416-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proof (Portuguese (Brazil)) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
28	Sentinel System Driver Installer 7.4.0	Sentinel System Driver Installer 7.4.0					{62B74257-2E1B-48FB-843C-0FBA43FE1327}	2012-03-02 00:00:00	Sentinel System Driver Installer 7.4.0	SafeNet, Inc.	7	4	0	\N	Gen	\N
29	PcMiscellaneousInterface	PcMiscellaneousInterface					{8E558C3D-5E45-464e-B3FA-C80C75909789}	2012-03-02 00:00:00	PcMiscellaneousInterface	NCR	3	0	0	\N	Feat	\N
30	USB80MM	USB80MM					{45FFC4B0-D2F6-444F-9E92-8BBBD814562B}	2012-08-30 00:00:00	USB80MM	NCR Corporation	1	0	0	\N	Feat	\N
31	PcGBRU	PcGBRU					{88BF0027-6DFA-11D8-AD6D-0050DA582602}	2012-11-06 00:00:00	PcGBRU	NCR	92	0	1	3	Feat	\N
32	PIVAT Chipset	PIVAT Chipset					{E6599384-6EBD-44D8-BCC5-465CED7F5469}	2012-03-02 00:00:00	PIVAT Chipset	NCR	1	0	0	\N	Feat	\N
33	XFS PIN Service Provider	XFS PIN Service Provider					{6B9E4C56-4FA3-4C80-9574-467D24D1EE7F}	2012-03-02 00:00:00	XFS PIN Service Provider	NCR	3	0	0	0	XFS	\N
34	Pc40ColumnThermalPrinters	Pc40ColumnThermalPrinters					{421BBC0A-B6B0-494e-BC74-04DB88C36ACA}	2012-03-02 00:00:00	Pc40ColumnThermalPrinters	NCR	3	0	5	\N	Feat	\N
35	XFS IDC Service Provider	XFS IDC Service Provider					{22606C55-4F1A-4720-8755-8D1A5F5322D3}	2012-09-07 00:00:00	XFS IDC Service Provider	NCR	3	0	0	5	XFS	\N
36	MEEICnf	MEEICnf					{1AF4837B-F087-4DCF-B62C-C6AACEEB11BF}	2012-03-02 00:00:00	MEEICnf	NCR	1	0	0	\N	Feat	\N
37	Serial Detector	Serial Detector					{ADA8A992-3C6C-4757-A90F-FBB498F66B47}	2012-03-02 00:00:00	Serial Detector	NCR	2	0	0	\N	Feat	\N
38	XFS UPTR Service Provider	XFS UPTR Service Provider					{1D8DDDEE-1CB0-4587-ACB2-83B88C2E2333}	2012-03-02 00:00:00	XFS UPTR Service Provider	NCR Corporation	1	0	0	\N	XFS	\N
39	Keyboard/Mouse SSPB Kernel Subsystem	Keyboard/Mouse SSPB Kernel Subsystem					{7D760829-2B92-11D6-989C-00D0B759864F}	2012-03-02 00:00:00	Keyboard/Mouse SSPB Kernel Subsystem	NCR	1	0	0	\N	Feat	\N
121	RS232ExteriorTouchScreen	RS232ExteriorTouchScreen					{75D7DAB2-1376-487A-83EA-23F974536327}	2010-11-30 00:00:00	RS232ExteriorTouchScreen	NCR	2	3	0	\N	Feat	\N
40	Microsoft Office PowerPoint MUI (Spanish) 2007	Microsoft Office PowerPoint MUI (Spanish) 2007					{90120000-0018-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office PowerPoint MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
41	Problem Determination Collection	Problem Determination Collection					{1F13F743-21D6-4525-A856-97C7FC86919A}	2012-03-06 00:00:00	Problem Determination Collection	NCR	2	6	1	\N	Feat	\N
42	UsbSmartCardReader	UsbSmartCardReader					{93D000FC-2723-44F1-BF6A-BF9FC704D42E}	2012-09-07 00:00:00	UsbSmartCardReader	NCR APTRA	1	0	0	\N	Feat	\N
43	RS232BNA	RS232BNA					{24C9BB75-5553-11D7-869F-0060972283F5}	2013-01-10 00:00:00	RS232BNA	NCR	95	1	1	3	Feat	\N
44	PcSound	PcSound					{0F54097C-2B84-44f5-8ECC-29012624F939}	2012-03-02 00:00:00	PcSound	NCR	4	0	0	\N	Feat	\N
45	3rd Party Runtime	3rd Party Runtime					{9BB70B2A-05C3-4AA9-AFC6-D4839F243F8A}	2012-03-15 00:00:00	3rd Party Runtime	NCR	2	1	1	\N	Feat	\N
46	USBTouchScreen	USBTouchScreen					{B99557E6-FF52-4A46-8571-2C4D90633A6B}	2012-03-02 00:00:00	USBTouchScreen	NCR	1	0	0	\N	Feat	\N
47	XFS SIU Service Provider	XFS SIU Service Provider					{505005FC-9433-4378-AC66-8186B5ABCDA8}	2012-03-13 00:00:00	XFS SIU Service Provider	NCR	3	0	0	3	XFS	\N
48	Microsoft Office Excel MUI (Spanish) 2007	Microsoft Office Excel MUI (Spanish) 2007					{90120000-0016-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Excel MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
49	XFS VDM Service Provider	XFS VDM Service Provider					{9B5C7C97-FC04-4453-BF02-19E7D3502BBB}	2012-03-02 00:00:00	XFS VDM Service Provider	NCR	3	0	0	3	XFS	\N
50	Self-Service Support Runtime Core	Self-Service Support Runtime Core					{BF45A903-74EE-4EC9-B452-5DDABD21028D}	2012-03-02 00:00:00	Self-Service Support Runtime Core	NCR	3	0	2	\N	Feat	\N
51	USBPTPB	USBPTPB					{CB669DA9-F701-46D9-BBCE-D1351C88F913}	2012-09-28 00:00:00	USBPTPB	NCR	1	0	0	\N	Feat	\N
52	PIVAT Sound	PIVAT Sound					{5BBC0DD6-730D-47C6-A207-744D2D864815}	2012-03-02 00:00:00	PIVAT Sound	NCR	1	0	2	\N	Feat	\N
53	Microsoft Office Proof (English) 2007	Microsoft Office Proof (English) 2007					{90120000-001F-0409-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proof (English) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
54	Microsoft Office Proofing (Spanish) 2007	Microsoft Office Proofing (Spanish) 2007					{90120000-002C-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proofing (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
55	USBMiscellaneousInterface	USBMiscellaneousInterface					{05BB0280-B54B-480A-BC49-1E34C1FC9E9E}	2012-03-02 00:00:00	USBMiscellaneousInterface	NCR	1	0	0	\N	Feat	\N
56	Microsoft Office Enterprise 2007	Microsoft Office Enterprise 2007					{90120000-0030-0000-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Enterprise 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
57	Microsoft Office Publisher MUI (Spanish) 2007	Microsoft Office Publisher MUI (Spanish) 2007					{90120000-0019-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Publisher MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
58	WMIDProv	WMIDProv					{46B3ABB0-94C3-4446-A702-1AA529E55C9A}	2012-03-02 00:00:00	WMIDProv	NCR	1	0	0	\N	Feat	\N
59	USB Coin Dispenser	USB Coin Dispenser					{9007DE40-1D59-47D0-B668-945B3EF3E27D}	2012-03-02 00:00:00	USB Coin Dispenser	NCR	1	0	0	\N	Feat	\N
60	UsbFraudDetection	UsbFraudDetection					{38DD436E-094E-4721-B681-3381BFBFC5DC}	2012-03-13 00:00:00	UsbFraudDetection	NCR APTRA	1	0	0	\N	Feat	\N
61	Microsoft Office Proof (Galician) 2007	Microsoft Office Proof (Galician) 2007					{90120000-001F-0456-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proof (Galician) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
62	SdcMiscellaneousInterface	SdcMiscellaneousInterface					{44A3A427-70CC-4aaf-BEA7-4158EE0E7103}	2012-03-02 00:00:00	SdcMiscellaneousInterface	NCR	3	0	0	\N	Feat	\N
63	Windows Communication Foundation	Windows Communication Foundation					{491DD792-AD81-429C-9EB4-86DD3D22E333}	2012-03-15 00:00:00	Windows Communication Foundation	Microsoft Corporation	3	0	4506	30	Gen	\N
64	USB Loader Service	USB Loader Service					{4EAEAE3E-B7EA-4CB4-89C4-A7DFB63BCD87}	2012-03-02 00:00:00	USB Loader Service	NCR	1	0	0	\N	Feat	\N
65	XFS TTU Service Provider	XFS TTU Service Provider					{EE8F54CD-9F76-4F53-AD31-1F971723B677}	2012-03-02 00:00:00	XFS TTU Service Provider	NCR	3	0	0	0	XFS	\N
66	RS232PageTurnPassbook	RS232PageTurnPassbook					{6341CF54-7958-4c0c-A0A0-669D6DEDB821}	2012-06-12 00:00:00	RS232PageTurnPassbook	NCR	4	0	2	\N	Feat	\N
67	Aggregate Builder	Aggregate Builder					{F001F469-BEDA-4AB2-93D0-522F3F2F5D2C}	2012-06-12 00:00:00	Aggregate Builder	NCR	92	8	0	1	Feat	\N
68	Microsoft Office Access MUI (Spanish) 2007	Microsoft Office Access MUI (Spanish) 2007					{90120000-0015-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Access MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
69	XFS PTR Service Provider	XFS PTR Service Provider					{83CE7497-02B2-4691-84E7-19D83CFDA087}	2012-09-26 00:00:00	XFS PTR Service Provider	NCR	1	0	0	4	XFS	\N
70	Adobe Reader 6.0.1	Adobe Reader 6.0.1					{AC76BA86-7AD7-1033-7B44-A00000000001}	2012-03-02 00:00:00	Adobe Reader 6.0.1	Adobe Systems Incorporated	6	0	1	\N	Gen	\N
71	XFS Logical Name Resolver	XFS Logical Name Resolver					{B5D40803-83F0-4081-A390-CEE4F1D2E25D}	2012-03-02 00:00:00	XFS Logical Name Resolver	NCR Corporation	1	0	0	\N	Feat	\N
72	XFS CIM Service Provider	XFS CIM Service Provider					{5CDB2BB5-F637-4A7E-B713-AED4F63E7335}	2013-01-10 00:00:00	XFS CIM Service Provider	NCR	2	0	0	0	XFS	\N
73	RS232IMCRW	RS232IMCRW					{6DA338C7-69F1-48C1-ADD3-1419773FD359}	2012-03-02 00:00:00	RS232IMCRW	NCR	92	0	6	3	Feat	\N
74	XFS GBRU-GBNA Service Provider	XFS GBRU-GBNA Service Provider					{37CE8C6A-6C62-45E0-8421-2A1B1864C177}	2012-03-02 00:00:00	XFS GBRU-GBNA Service Provider	NCR Corporation	1	0	0	\N	XFS	\N
75	PcQwertyKeyboard	PcQwertyKeyboard					{556B33D6-93F6-4754-BFA1-DD04B21A4784}	2012-03-02 00:00:00	PcQwertyKeyboard	NCR	1	0	0	\N	Feat	\N
76	USBUop	USBUop					{18664F05-F838-4F5F-B87F-0ADF615D07DB}	2012-03-02 00:00:00	USBUop	NCR	1	0	0	\N	Feat	\N
77	Microsoft Office Outlook MUI (Spanish) 2007	Microsoft Office Outlook MUI (Spanish) 2007					{90120000-001A-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Outlook MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
78	XFS Manager	XFS Manager					{7D4B1A8A-863E-4930-87BE-3BBCBC80F412}	2012-03-02 00:00:00	XFS Manager	NCR	3	0	0	0	Feat	\N
135	SPSDACT	SPSDACT					{ADA69B04-772B-4C4B-94A9-CC32A6EE98CB}	2013-02-13 00:00:00	SPSDACT	NCR APTRA	1	0	0	\N	Feat	\N
79	Adobe Acrobat 6.0 Professional - English, Français, Deutsch	Adobe Acrobat 6.0 Professional - English, Français, Deutsch					{AC76BA86-1033-F400-7760-000000000001}	2012-03-05 00:00:00	Adobe Acrobat 6.0 Professional - English, Français, Deutsch	Adobe Systems	6	0	0	\N	Gen	\N
80	Mode Switch	Mode Switch					{44C06257-33ED-4658-8528-085EDAB00A0B}	2012-03-02 00:00:00	Mode Switch	NCR	3	1	0	\N	Feat	\N
81	Sdc Primary	Sdc Primary					{F15DF717-B828-4744-93DB-625B1A6561C4}	2012-03-02 00:00:00	Sdc Primary	NCR	3	0	0	\N	Feat	\N
82	Microsoft Office Groove MUI (Spanish) 2007	Microsoft Office Groove MUI (Spanish) 2007					{90120000-00BA-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Groove MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
83	Self-Service Support Keyboards Configuration	Self-Service Support Keyboards Configuration					{5AB76BBF-4B2A-4CD3-B3F3-2E0CEC7A5DC6}	2012-03-02 00:00:00	Self-Service Support Keyboards Configuration	NCR	4	0	0	\N	Feat	\N
84	SdcRs232	SdcRs232					{78D58FA1-5BCE-4D69-8552-4753136204D7}	2012-03-02 00:00:00	SdcRs232	NCR	3	0	0	\N	Feat	\N
85	Microsoft Office InfoPath MUI (Spanish) 2007	Microsoft Office InfoPath MUI (Spanish) 2007					{90120000-0044-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office InfoPath MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
86	Microsoft Software Update for Web Folders  (Spanish) 12	Microsoft Software Update for Web Folders  (Spanish) 12					{90120000-0010-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Software Update for Web Folders  (Spanish) 12	Microsoft Corporation	12	0	4518	1014	Gen	\N
87	Windows Genuine Advantage v1.3.0254.0	Windows Genuine Advantage v1.3.0254.0					{63569CE9-FA00-469C-AF5C-E5D4D93ACF91}	2005-10-26 00:00:00	Windows Genuine Advantage v1.3.0254.0	Microsoft	1	3	254	0	Gen	\N
88	FeatureSupport	FeatureSupport					{8D85442D-5F37-4A5E-973A-1D96B60242E0}	2012-03-02 00:00:00	FeatureSupport	NCR	1	0	0	0	Feat	\N
89	Microsoft Office Shared MUI (Spanish) 2007	Microsoft Office Shared MUI (Spanish) 2007					{90120000-006E-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Shared MUI (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
90	Microsoft Office Proof (Spanish) 2007	Microsoft Office Proof (Spanish) 2007					{90120000-001F-0C0A-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proof (Spanish) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
91	Microsoft Office Proof (Basque) 2007	Microsoft Office Proof (Basque) 2007					{90120000-001F-042D-0000-0000000FF1CE}	2012-03-05 00:00:00	Microsoft Office Proof (Basque) 2007	Microsoft Corporation	12	0	4518	1014	Gen	\N
92	PcMonitor	PcMonitor					{972F3431-7CB3-4A32-B2E5-65933B0A6B95}	2012-03-02 00:00:00	PcMonitor	NCR	1	0	0	\N	Feat	\N
93	USBEnvelopeDepository	USBEnvelopeDepository					{1D23D1E4-AF80-48BE-BFE7-A0C9C1795084}	2012-07-17 00:00:00	USBEnvelopeDepository	NCR Corporation	1	0	0	\N	Feat	\N
94	USBBNA	USBBNA					{FF0FE676-46D3-407F-AE90-B827D40DCEAC}	2012-07-17 00:00:00	USBBNA	NCR	92	1	1	2	Feat	\N
95	USB Encrypting Pin Pad 2	USB Encrypting Pin Pad 2					{B840D9D7-74DE-4654-A4A7-21DBCF89392E}	2012-07-17 00:00:00	USB Encrypting Pin Pad 2	NCR	1	0	0	\N	Feat	\N
96	USBAcousticWaveTouchScreen	USBAcousticWaveTouchScreen					{00D38591-CC33-476D-8E82-C1E4AFCB9397}	2012-07-17 00:00:00	USBAcousticWaveTouchScreen	NCR	1	0	0	\N	Feat	\N
97	FLM_6631	FLM_6631					{D8BC9D39-C707-4598-9680-71A08B65D440}	2012-07-17 00:00:00	FLM_6631	NCR	1	0	0	0	Feat	\N
98	MSXML 4.0 SP2 (KB973688)	MSXML 4.0 SP2 (KB973688)					{F662A8E6-F4DC-41A2-901E-8C11F044BDEC}	2010-11-30 00:00:00	MSXML 4.0 SP2 (KB973688)	Microsoft Corporation	4	20	9876	0	Gen	\N
99	Talladega Sound	Talladega Sound					{5D984452-BE9E-41B2-948B-73D725426655}	2010-11-30 00:00:00	Talladega Sound	NCR	1	0	0	\N	Feat	\N
100	FLM_6628	FLM_6628					{066325D3-0A4C-45D3-A642-B8119DFE0DE0}	2012-07-17 00:00:00	FLM_6628	NCR	1	0	0	0	Feat	\N
101	FLM_6642	FLM_6642					{3DD26D08-1FA4-4009-8B63-C6CC9762169E}	2012-07-17 00:00:00	FLM_6642	NCR	1	0	0	0	Feat	\N
102	FLM_2008	FLM_2008					{3BDBF1A6-00AA-478B-9FAE-38EF154D9F52}	2012-07-17 00:00:00	FLM_2008	NCR	1	0	0	0	Feat	\N
103	FLM_6634	FLM_6634					{B8739C1E-DB2A-4B74-B474-4DF166DA1677}	2012-07-17 00:00:00	FLM_6634	NCR	1	0	0	0	Feat	\N
104	FLM_6636	FLM_6636					{3F15086B-AD6A-4E37-BC15-494D8B9A7326}	2012-07-17 00:00:00	FLM_6636	NCR	1	0	0	0	Feat	\N
105	FLM_6626	FLM_6626					{24AAF635-D64D-4959-8468-5486B4D75FBC}	2012-07-17 00:00:00	FLM_6626	NCR	1	0	0	0	Feat	\N
106	FLM_6676	FLM_6676					{D205DB3E-E30F-48D2-A550-325D1C8355DC}	2012-07-17 00:00:00	FLM_6676	NCR	1	0	0	0	Feat	\N
107	XFS EDEP Service Provider	XFS EDEP Service Provider					{5A34F2CB-93EC-4dc9-9B83-FBD5B77BCA9B}	2010-11-30 00:00:00	XFS EDEP Service Provider	NCR	3	0	0	5	XFS	\N
108	FLM_6674	FLM_6674					{E8ADCEF6-9B03-4F0C-B28B-61EE91C39D1F}	2012-07-17 00:00:00	FLM_6674	NCR	1	0	0	0	Feat	\N
109	PCISerial	PCISerial					{27FAC828-E787-4A2E-9AED-6329C4B928FB}	2012-07-17 00:00:00	PCISerial	NCR	1	0	2	\N	Feat	\N
110	FLM_6654	FLM_6654					{4D50D948-CB44-4D40-AAD4-5D38A7CFBC53}	2012-07-17 00:00:00	FLM_6654	NCR	1	0	0	0	Feat	\N
111	FLM_Media	FLM_Media					{1D980821-1EEB-4A4A-8592-0707556DE558}	2012-07-17 00:00:00	FLM_Media	NCR	1	0	0	0	Feat	\N
112	FLM_6617	FLM_6617					{4C0330A8-183D-46C9-9334-00E093EBFB48}	2012-07-17 00:00:00	FLM_6617	NCR	1	0	0	0	Feat	\N
113	RS232BarcodeReader	RS232BarcodeReader					{4B9F0FE7-8E61-423e-9EDE-D41C5D8B1830}	2010-11-30 00:00:00	RS232BarcodeReader	NCR	2	0	2	\N	Feat	\N
114	FLM_6632	FLM_6632					{DC3C391A-4559-4882-89FC-72CFD3BB282B}	2012-07-17 00:00:00	FLM_6632	NCR	1	0	0	0	Feat	\N
115	USBCurrencyDispenser	USBCurrencyDispenser					{88075C8F-E7B6-42E0-A5A0-C6C1DD15B072}	2012-07-17 00:00:00	USBCurrencyDispenser	NCR	1	0	0	\N	Feat	\N
116	FLM_6622	FLM_6622					{AAD4AB68-3ABB-4D18-B4E9-20D963E99E4A}	2012-07-17 00:00:00	FLM_6622	NCR	1	0	0	0	Feat	\N
117	FLM_6618	FLM_6618					{090DDBC9-D5D0-4132-8116-2B5C42C184C2}	2012-07-17 00:00:00	FLM_6618	NCR	1	0	0	0	Feat	\N
118	USB Integrated Motorised Card Reader Writer	USB Integrated Motorised Card Reader Writer					{EB3F80A9-AD3D-4F90-B193-8A6ED389E413}	2010-11-30 00:00:00	USB Integrated Motorised Card Reader Writer	NCR	1	0	0	\N	Feat	\N
119	RS232ContactlessCardReader	RS232ContactlessCardReader					{455A7F1A-12F4-4C74-8E89-A5604E100DC9}	2012-07-17 00:00:00	RS232ContactlessCardReader	NCR APTRA	1	0	0	\N	Feat	\N
120	USBGDSTouchscreen	USBGDSTouchscreen					{C49C9CDA-4D29-4000-9D54-D61712191370}	2012-07-17 00:00:00	USBGDSTouchscreen	NCR Corporation	91	0	1	3	Feat	\N
122	SdcMotorisedCardReaderWriter	SdcMotorisedCardReaderWriter					{505732F4-AD18-47fe-A1D8-82CA3E024264}	2010-11-30 00:00:00	SdcMotorisedCardReaderWriter	NCR	3	0	2	\N	Feat	\N
123	SdcEDep	SdcEDep					{FBB20F13-E8B6-4aa6-A234-378CB5AA83F8}	2010-11-30 00:00:00	SdcEDep	NCR	3	0	7	\N	Feat	\N
124	SdcEop	SdcEop					{AE6141E5-6597-410a-9D55-C1AB20F525F3}	2010-11-30 00:00:00	SdcEop	NCR	3	0	0	\N	Feat	\N
125	FLM_6625	FLM_6625					{C638FD05-2373-4729-8175-207D00A91EE7}	2012-07-17 00:00:00	FLM_6625	NCR	1	0	0	0	Feat	\N
126	FLM_6638	FLM_6638					{714E7DC6-9058-401E-AF2A-71E79257246D}	2012-07-17 00:00:00	FLM_6638	NCR	1	0	0	0	Feat	\N
127	Talladega Chipset	Talladega Chipset					{2459F6C1-D145-44F8-A820-B8857D43E61D}	2010-11-30 00:00:00	Talladega Chipset	NCR	1	0	0	\N	Feat	\N
128	Sdc40ColumnDotMatrixPrinters	Sdc40ColumnDotMatrixPrinters					{181DBCCF-7B7C-4d0e-9F2C-BBBCF3D4B6F0}	2010-11-30 00:00:00	Sdc40ColumnDotMatrixPrinters	NCR	3	0	0	\N	Feat	\N
129	USBContactlessCardReader	USBContactlessCardReader					{0D284D53-A541-4907-9868-BDAC644CCAC8}	2011-06-21 00:00:00	USBContactlessCardReader	NCR Aptra	1	0	0	\N	Feat	\N
130	XFS Contactless Card Reader Service Provider	XFS Contactless Card Reader Service Provider					{A2344DD4-A1FF-4E25-9509-94E579DFC6E0}	2011-06-21 00:00:00	XFS Contactless Card Reader Service Provider	Default Company Name	1	0	0	\N	Gen	\N
131	FLM_2012	FLM_2012					{6F9F9DA5-3DED-4A05-A5CA-955F2C049B23}	2012-07-17 00:00:00	FLM_2012	NCR	1	0	0	0	Feat	\N
132	PcAcousticWaveTouchScreen	PcAcousticWaveTouchScreen					{339926BE-83BC-4acb-983B-64E3C1AE3154}	2010-11-30 00:00:00	PcAcousticWaveTouchScreen	NCR	3	1	0	\N	Feat	\N
133	FLM_2004	FLM_2004					{865E683A-AA69-48B7-BB23-141FB26D3A27}	2012-07-17 00:00:00	FLM_2004	NCR	1	0	0	0	Feat	\N
134	MSXML 4.0 SP2 (KB954430)	MSXML 4.0 SP2 (KB954430)					{86493ADD-824D-4B8E-BD72-8C5DCDC52A71}	2009-09-25 00:00:00	MSXML 4.0 SP2 (KB954430)	Microsoft Corporation	4	20	9870	0	Gen	\N
152	USBAntiSkimmingModule	USBAntiSkimmingModule					{D99B9242-CB24-4A17-966E-524991188BD4}	2013-03-13 00:00:00	USBAntiSkimmingModule	NCR APTRA	1	0	0	\N	Feat	\N
153	Oracle VM VirtualBox 4.1.18	Oracle VM VirtualBox 4.1.18					{D3F9003B-7D17-4317-B61B-0694FF5333F8}	2013-03-04 00:00:00	Oracle VM VirtualBox 4.1.18	Oracle Corporation	4	1	18	\N	Gen	\N
154	SDMIBVMDLF	SDMIBVMDLF					{94CB2A9A-6469-45D9-8873-83501853F0E8}	2013-05-14 00:00:00	SDMIBVMDLF	NCR	1	0	0	1	Feat	\N
155	XFS SDM Service Provider	XFS SDM Service Provider					{E0DD111B-992F-4BA0-BBBA-CCCA9275FD8D}	2013-05-10 00:00:00	XFS SDM Service Provider	NCR Corporation	1	0	0	\N	XFS	\N
156	USBSDM	USBSDM					{980340E6-D452-4870-931B-A89DA95FA902}	2013-05-10 00:00:00	USBSDM	NCR	2	0	0	29	Feat	\N
158	Microsoft Visual C++ 2010  x86 Redistributable - 10.0.40219	Microsoft Visual C++ 2010  x86 Redistributable - 10.0.40219					{F0C3E5D1-1ADE-321E-8167-68EF0DE699A5}	2013-06-26 00:00:00	Microsoft Visual C++ 2010  x86 Redistributable - 10.0.40219	Microsoft Corporation	10	0	40219	\N	Gen	\N
159	CPM eCR-PLUS Runtime	CPM eCR-PLUS Runtime					{BB02B06A-FD4B-4FB1-BBAC-66D1DB062982}	2013-08-15 00:00:00	CPM eCR-PLUS Runtime	NCR	1	2	0	3	Feat	\N
140	Intel(R) PRO Network Connections 10.3.32.2	Intel(R) PRO Network Connections 10.3.32.2					{205C26CB-6D52-458C-A87F-1EE77F9625C6}	2007-08-28 00:00:00	Intel(R) PRO Network Connections 10.3.32.2	Intel	10	30	0	\N	Gen	\N
136	SNMP Master Agent 01.02.00	SNMP Master Agent 01.02.00					{A3284C62-DA36-43A5-A13D-1F67A5CC0530}	2009-04-03 00:00:00	SNMP Master Agent 01.02.00	NCR	1	2	0	\N	Feat	\N
138	Intel(R) PROSafe for Wired Connections	Intel(R) PROSafe for Wired Connections					{403EF592-953B-4794-BCEF-ECAB835C2095}	2007-08-27 00:00:00	Intel(R) PROSafe for Wired Connections	\N	8	0	5	\N	Gen	\N
139	MSXML 6.0 Parser	MSXML 6.0 Parser					{AEB9948B-4FF2-47C9-990E-47014492A0FE}	2012-12-05 00:00:00	MSXML 6.0 Parser	Microsoft Corporation	6	0	3883	8	Gen	\N
137	Solidcore for APTRA	Solidcore for APTRA					{432DB9E4-6388-432F-9ADB-61E8782F4593}	2010-11-18 00:00:00	Solidcore for APTRA	Solidcore Systems	4	6	8	2217	Gen	\N
\.


--
-- Data for Name: software_aggregates; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY software_aggregates (id, description, numbr, name, profile, major_version, minor_version, build_version, revision_version, remaining_version) FROM stdin;
1	SP1	\N	USB PassbookPrinter Update	USBPTPB	5	1	0	\N	\N
3	Upgrade componentes Dispensador de Efectivo	\N	CDM Sermepa	CDM	5	1	0	\N	\N
4	SP1	\N	XFS Manager	XFS	5	1	0	\N	\N
5	APTRA Simulator	\N	APTRA Simulator		93	0	0	6	\N
6	Update Final Certification 91.00.02.05	\N	USBPTPB 1.1.0	USBPTPB	5	1	0	\N	\N
7	APTRA Teller Cash Base	\N	APTRA Teller Cash Base		1	3	0	\N	\N
8	Upgrade IFD component	\N	IFD 91010107	IFD	5	1	0	\N	\N
9	Update Test Template	\N	TEST TEMPLATE	TE	1	3	0	\N	\N
10	Testing Banco Sabadell EAN128	\N	Barcode Reader	Barcode	5	1	0	\N	\N
11	Update Final Certification 91.00.02.05	\N	USBPTPB 1.1.0	USBPTPB	5	1	0	\N	\N
12	Test	\N	CDM Cajamar	CDM	5	0	0	\N	\N
13	SP1	\N	CDM SP Update	CDM	5	1	0	\N	\N
14	New Aggregate Description	\N	Prueba Caja Laboral	gbru	1	0	0	\N	\N
15	SIU + IFD	\N	IFD Update	IFD	5	1	0	\N	\N
16	New Aggregate Description	\N	RS232PassbookPrinter	PPTR	1	0	0	\N	\N
17	SP1	\N	RawData	USB80	5	1	0	\N	\N
18	Update for HBV certification	\N	BNA2 HBV Update	BNA	5	1	0	\N	\N
19	New Aggregate Description	\N	RS232BNA	BNA	1	0	0	\N	\N
20	Tests	\N	CaixaBankTest	RS232PTPB	1	0	0	\N	\N
21	SP1	\N	Dip Reader Package	DIP	5	1	0	\N	\N
22	Upgrade	\N	CatalunyaCaixaTest	CX	5	1	0	\N	\N
23	Update GOP Components	\N	GOP	GOP	5	1	0	\N	\N
24	Upgrade RawData	\N	CaixaBank	URPTR	5	1	0	\N	\N
25	Upgrade version	\N	IFD	IFD	5	1	0	\N	\N
27	Update Feature and SP from SP1	\N	RS232BNA_SP1	BNA	5	1	0	\N	\N
28	Update	\N	GOP SP1	GOP	5	1	0	\N	\N
29	Actualizados parches Aptra 05.01.00 hasta 06/07/2011	\N	ActBBK_2	ActBBK	1	0	0	\N	\N
31	APTRA XFS 05.01.00	\N	BBK	BBK	5	1	0	\N	\N
32	Upgrade KutxaBank	\N	KutxaBank	KutxaBank	5	1	0	\N	\N
33	Actualizados parches Aptra 05.01.00 hasta 01/06/2011	\N	ActBBK	ActBBK	1	0	0	\N	\N
35	SPS Detection Enablement for APTRA	\N	SPS Detection Enablement for APTRA		1	0	0	\N	\N
30	Actualización PcGbruEU	\N	PCGBRUEU	PcGbruEU	5	1	0	\N	\N
26	Actualización p76 - Pivat	\N	Update Aptra XFS	UPDATE	5	1	0	\N	\N
2	GBNA Migration	\N	GBNA Update	GBNA	5	1	0	\N	\N
36	Builder para el master hardware xp de Caja Madrid con versión de Aptra 5.0	\N	Caja Madrid	Caja Madrid 02.50.00	2	50	0	\N	\N
37	Self Service Assistant for APTRA Development License	\N	Self Service Assistant for APTRA Development License		2	1	0	\N	\N
38	Instalacion SolidCore Caja Madrid	\N	SolidCore (Caja Madrid)		1	0	5	\N	\N
76	Upgrade SPS for testing purposes	\N	SPS Upgrade	SPS	6	1	1	\N	\N
77	Upgrade Dispensers	\N	Dispensers Update	DISP	5	1	0	\N	\N
78	Elo USB para Redsys	\N	Agg_SAW_Redsys	Redsys	1	0	0	\N	\N
79	Templates Download HBV	\N	Cajamar Testing	HBV	1	0	0	\N	\N
80	OCR Codeline	\N	SDM Update	SDM	6	1	1	\N	\N
81	GBRU Feature + SP	\N	GBRU-GBNA Upgrade	NCR	6	1	1	\N	\N
82	New Aggregate Description	\N	Nuevo driver dispensador USB	CDM	1	0	0	\N	\N
85	Pack SPS + Detection Test License	\N	SPS Bankia	SPS	1	0	0	\N	\N
86	Fixes reported by SIBS	\N	SDM Upgrade SIBS	SIBS	1	0	1	\N	\N
87	New Aggregate Description	\N	Plus SDM	SDM	1	0	0	\N	\N
88	Fixes reported by SIBS	\N	SDM Upgrade SIBS	SIBS	1	0	0	\N	\N
\.


--
-- Name: software_aggregates_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('software_aggregates_id_seq', 88, true);


--
-- Name: software_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('software_id_seq', 159, true);


--
-- Data for Name: t_config_op_system; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY t_config_op_system (terminal_config_id, operating_system_id) FROM stdin;
1	1
2	2
3	3
4	4
7	2
9	3
10	3
11	3
13	8
14	8
6	6
\.


--
-- Data for Name: terminal_config_software; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY terminal_config_software (terminal_config_id, software_id) FROM stdin;
1	16
1	5
1	1
1	10
1	3
1	4
1	7
1	14
1	6
1	13
1	8
1	9
1	11
1	2
1	15
1	12
2	75
2	22
2	56
2	12
2	88
2	21
2	58
2	74
2	35
2	82
2	71
2	44
2	37
2	79
2	68
2	33
2	39
2	19
2	32
2	9
2	47
2	40
2	14
2	55
2	61
2	87
2	76
2	53
2	63
2	51
2	89
2	50
2	62
2	91
2	36
2	23
2	38
2	18
2	57
2	29
2	73
2	17
2	48
2	54
2	49
2	43
2	84
2	77
2	31
2	85
2	20
2	45
2	26
2	70
2	64
2	28
2	69
2	42
2	90
2	86
2	78
2	72
2	65
2	67
2	59
2	81
2	25
2	24
2	52
2	66
2	41
2	92
2	34
2	27
2	60
2	30
2	83
2	3
2	80
2	46
3	125
3	45
3	66
3	31
3	98
3	88
3	93
3	111
3	30
3	112
3	115
3	113
3	122
3	46
3	39
3	106
3	44
3	22
3	47
3	35
3	81
3	38
3	65
3	102
3	126
3	84
3	104
3	100
3	120
3	94
3	20
3	60
3	123
3	32
3	105
3	114
3	21
3	33
3	83
3	37
3	99
3	9
3	121
3	130
3	64
3	101
3	110
3	116
3	80
3	24
3	133
3	124
3	108
3	3
3	78
3	103
3	129
3	58
3	49
3	70
3	18
3	127
3	55
3	52
3	50
3	128
3	51
3	107
3	72
3	96
3	75
3	73
3	117
3	109
3	74
3	132
3	23
3	134
3	34
3	95
3	92
3	118
3	62
3	69
3	97
3	131
3	28
3	71
3	119
3	29
3	76
3	14
4	34
4	100
4	117
4	101
4	108
4	32
4	72
4	105
4	46
4	125
4	112
4	18
4	133
4	107
4	65
4	115
4	88
4	126
4	62
4	120
4	123
4	102
4	134
4	28
4	124
4	20
4	78
4	110
4	51
4	111
4	30
4	96
4	109
4	39
4	119
4	94
4	58
4	106
4	95
4	103
4	45
4	74
4	29
4	118
4	22
4	130
4	31
4	71
4	81
4	3
4	47
4	92
4	23
4	114
4	52
4	131
4	70
4	64
4	75
4	116
4	97
4	21
4	113
4	24
4	9
4	104
4	69
4	37
4	83
4	50
4	84
4	14
4	135
4	76
4	127
4	44
4	55
4	35
4	80
4	60
4	66
4	121
4	99
4	98
4	33
4	132
4	43
4	93
4	38
4	73
4	122
4	49
4	128
4	129
7	3
6	9
6	3
6	20
6	22
6	30
6	44
6	45
7	9
7	12
7	14
7	17
7	18
7	19
7	20
7	21
7	22
7	23
7	24
7	25
7	26
7	27
7	28
7	29
7	30
7	31
7	32
7	33
7	34
7	35
7	36
7	37
7	38
7	39
7	40
7	41
7	42
7	43
7	44
7	45
7	46
7	47
7	48
7	49
7	50
7	51
7	52
7	53
7	54
7	55
7	56
7	58
7	57
7	59
7	60
7	61
7	62
7	63
7	64
7	65
7	66
7	67
7	68
7	69
7	70
7	71
7	72
7	73
7	74
7	75
7	76
7	77
7	78
7	79
7	80
7	81
7	82
7	83
7	84
7	85
7	86
7	87
7	88
7	89
7	90
7	91
7	92
7	137
9	49
9	111
9	29
9	98
9	52
9	50
9	64
9	34
9	9
9	84
9	134
9	47
9	119
9	106
9	125
9	126
9	38
9	32
9	96
9	153
9	72
9	128
9	44
9	107
9	97
9	135
9	14
9	114
9	123
9	58
9	122
9	23
9	80
9	21
9	117
9	88
9	71
9	69
9	100
9	95
9	35
9	37
9	108
9	124
9	66
9	22
9	62
9	78
9	102
9	109
9	93
9	116
9	133
9	129
9	130
9	152
9	99
9	115
9	118
9	30
9	120
9	55
9	75
9	33
9	81
9	24
9	127
9	70
9	131
9	101
9	113
9	60
9	92
9	104
9	28
9	39
9	46
9	18
9	45
9	73
9	110
9	103
9	3
9	65
9	112
9	31
9	105
9	83
9	94
9	51
9	74
9	76
9	132
9	20
9	121
10	132
10	72
10	102
10	130
10	133
10	18
10	122
10	92
10	113
10	29
10	33
10	153
10	23
10	31
10	114
10	96
10	50
10	152
10	22
10	70
10	20
10	74
10	55
10	34
10	51
10	59
10	135
10	9
10	58
10	95
10	84
10	129
10	123
10	80
10	105
10	64
10	117
10	108
10	116
10	119
10	120
10	131
10	125
10	39
10	60
10	93
10	103
10	127
10	62
10	30
10	128
10	111
10	28
10	104
10	99
10	121
10	24
10	46
10	45
10	98
10	97
10	14
10	37
10	75
10	124
10	118
10	38
10	47
10	100
10	65
10	78
10	134
10	101
10	126
10	52
10	21
10	88
10	94
10	49
10	106
10	35
10	71
10	3
10	107
10	115
10	32
10	109
10	81
10	112
10	76
10	44
10	69
10	73
10	66
10	83
10	110
11	60
11	58
11	72
11	125
11	46
11	153
11	29
11	52
11	83
11	112
11	55
11	122
11	102
11	64
11	114
11	65
11	119
11	93
11	23
11	156
11	134
11	69
11	121
11	59
11	155
11	38
11	74
11	70
11	18
11	73
11	78
11	51
11	47
11	123
11	104
11	154
11	33
11	62
11	130
11	45
11	117
11	96
11	24
11	32
11	34
11	44
11	113
11	105
11	22
11	14
11	97
11	37
11	9
11	101
11	31
11	152
11	76
11	126
11	106
11	108
11	111
11	66
11	129
11	118
11	115
11	88
11	133
11	100
11	103
11	84
11	95
11	21
11	120
11	28
11	109
11	131
11	135
11	35
11	75
11	50
11	98
11	71
11	94
11	132
11	49
11	80
11	99
11	92
11	3
11	39
11	127
11	124
11	116
11	20
11	107
11	128
11	30
11	110
11	81
13	126
13	50
13	33
13	132
13	49
13	78
13	55
13	96
13	22
13	51
13	127
13	116
13	123
13	74
13	21
13	112
13	117
13	80
13	20
13	99
13	30
13	65
13	106
13	44
13	95
13	110
13	124
13	111
13	76
13	152
13	34
13	60
13	72
13	66
13	114
13	75
13	131
13	125
13	45
13	134
13	31
13	156
13	9
13	102
13	133
13	38
13	103
13	70
13	81
13	97
13	109
13	23
13	58
13	3
13	93
13	104
13	128
13	14
13	37
13	113
13	101
13	122
13	35
13	105
13	69
13	115
13	83
13	108
13	39
13	118
13	47
13	24
13	28
13	46
13	64
13	121
13	120
13	129
13	94
13	107
13	130
13	29
13	158
13	92
13	52
13	98
13	73
13	100
13	71
13	32
13	43
13	62
13	88
13	18
13	119
13	84
14	45
14	44
14	31
14	21
14	158
14	92
14	73
14	93
14	71
14	78
14	112
14	66
14	64
14	127
14	33
14	135
14	134
14	104
14	9
14	95
14	155
14	154
14	28
14	103
14	96
14	130
14	101
14	20
14	70
14	37
14	46
14	39
14	128
14	125
14	99
14	51
14	18
14	55
14	80
14	107
14	116
14	34
14	47
14	105
14	50
14	76
14	35
14	110
14	75
14	121
14	72
14	83
14	52
14	120
14	100
14	102
14	58
14	106
14	113
14	159
14	156
14	69
14	3
14	126
14	114
14	43
14	152
14	74
14	23
14	117
14	109
14	30
14	129
14	123
14	88
14	24
14	132
14	81
14	94
14	122
14	84
14	22
14	14
14	115
14	65
14	98
14	32
14	111
14	108
14	131
14	62
14	38
14	49
14	119
14	29
14	133
14	60
14	124
14	97
14	118
6	37
6	49
6	65
6	66
6	69
6	50
6	71
6	78
6	80
6	81
6	92
6	111
6	121
6	123
6	124
6	55
6	136
6	137
\.


--
-- Data for Name: terminal_configs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY terminal_configs (id, start_date, terminal_id) FROM stdin;
1	2013-02-11 08:54:53.042	1
2	2013-02-11 09:06:22.775	2
3	2013-02-12 11:41:28.681	4
4	2013-02-13 12:15:17.781	5
6	2013-02-13 13:31:03.087	7
7	2013-02-13 18:03:23	2
9	2013-03-13 15:31:05.764	4
10	2013-04-09 12:32:47.264	4
11	2013-06-10 17:01:40.916	4
13	2013-08-14 17:16:06.657	4
14	2013-08-16 14:38:42.517	4
\.


--
-- Name: terminal_configs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('terminal_configs_id_seq', 14, true);


--
-- Data for Name: terminal_internet_explorer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY terminal_internet_explorer (terminal_id, internet_explorer_id) FROM stdin;
1	1
2	2
5	2
7	4
4	4
\.


--
-- Data for Name: terminal_software_aggregate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY terminal_software_aggregate (terminal_id, software_aggregate_id) FROM stdin;
1	3
1	2
1	1
1	5
1	4
1	7
1	6
1	8
1	9
2	10
2	11
2	12
2	13
2	14
2	15
2	18
2	17
2	16
2	19
2	21
2	20
2	22
2	23
2	25
2	24
2	28
2	27
2	26
5	35
5	33
5	30
5	29
5	31
5	32
4	30
4	88
4	87
4	31
4	29
4	32
4	33
4	85
7	36
7	37
7	38
\.


--
-- Data for Name: terminals; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY terminals (id, front_replenish, geographic_address, manufacturing_site, model, product_class, product_class_description, serial_number, terminal_type, terminal_vendor, tracer_number, address, area, bank, branch, city, country, ip, mac, zip_code) FROM stdin;
5	t	Madrid	8		6632		14896532	SST	NCR	0	C/ Albacete 3C	Centro	BBK	13	Madrid		135.130.13.118	00:1A:D4:0A:A3:B3	28027
1	f	Unknown		Latitude E5430	VMWare	Virtual Machine	1234	VirtualMachine	Dell		N/A	N/A	N/A	N/A	Madrid	Spain	135.130.15.106	00:0C:29:B1:CF:E8	280xx
7	f	Madrid	8		5875		34544382	SST	NCR		C/ Albacete 3C	Centro	Bankia	3434	Madrid	Spain	135.130.12.12	00:04:75:D9:2D:17	28027
2	f	Madrid	13	0300	6676		41113362	SST	NCR	696	C/ Albacete 3C	Centro	NCR	0121	Madrid	Spain	135.130.13.103	00:01:29:13:C9:B4	28027
4	f		8		6634		123456532	SST		0	C/ Alameda de Mazarredo 39	Norte	BBK_Test	1	Bilbao	Spain	135.130.15.232	00:1A:D4:17:97:20	48009
\.


--
-- Name: terminals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('terminals_id_seq', 7, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, firstname, lastname, username, passw, last_login, role_id) FROM stdin;
4	Jose	Gonzalez	jose	fc470837b621edbd5697a075c65e34a4c12676e4ffaec1661b7a8915245db1791a7ffd2d6cc5c87d	2013-02-14 12:39:41.493	2
1	John	Zoidberg	admin	23f82a4a78f9f294b7e1d6c03101632deb47019fc21b70a7759af5739ba1300961bf32ff331e0dbd	2013-10-04 16:25:41.374	1
2	Hubert	Farnsworth	data	26425264edfe9205de96d6ca39cb3b5cc6aa3e2ebb5a29df1134757bb81e4509987507a3614c76db	2013-09-17 11:13:36.367	3
3	Hermes	Conrad	guest	71315f191064d8193b5f4c78d3e03c9bad25fea855c7a590b336e1b4b377e00a536aa430fbf25a04	2013-09-17 11:13:49.74	4
5	Eva	Pindado	eva	baf054d3a6368b2930e3852c9afe511960c8fd6aa09c37059b38848fdf1b52b881000e29c6fa9dc8	2013-09-17 11:18:27.856	2
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 6, true);


--
-- Data for Name: xfs_components; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY xfs_components (id, accept_media, algorithms, autofix, auxiliaries, back_image_color_format, cameras, cam_data, can_open_safe_door, cards, cash_units, cen_major_version, cen_minor_version, cen_build_version, cen_revision_version, cen_remaining_version, char_support, chip_io, chip_power, chip_protocol, code_line_format, compound, compare_magnetic_stripe, control, cursor, dep_transport, derivation_algorithms, dispense_paper, display, display_light, door_safe, door_vandal_shield, doors, encoder, encode_names, endorser, envelope_supply, exchange_types, extents, extra, flux, font_names, forms, front_image_color_format, guidlights, has_cash_box, has_inserted_sensor, has_shutter, has_taken_sensor, id_connect, id_key, image_capture, image_source, image_type, indicators, intermediate_stacker, key_check_modes, key_lock, key_num, logical_name, magnetic_stripe_read, magnetic_stripe_write, max_cash_in_items, max_data_length, max_dispense_items, max_media_on_stacker, max_num_chars, max_pictures, max_retract, media_taken, micr, move_items, multi_page, num_leds, ocr, paper_sources, pin_formats, power_off, power_on, presentation_algorithms, printer, print_on_retracts, programatically_deactivate, read_form, read_tracks, read_write_after_eject, refill, resolution, resolutions, retract_areas, retract_bins, retract_envelope, retract_stacker_actions, retract_transport_actions, security_type, sensors, service_provider, shutter_control, stamp, supported_positions, toner, type, validation_algorithms, vendor, write_form, write_mode, write_tracks, xfs_class, financial_device_id) FROM stdin;
9	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_TTU_ASCII	\N	\N	\N	\N	\N	\N	\N	t	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=1 DEVICE1=UID=125,DEVNAME=OPP_-01-USBUOP,DEVVAR=1	\N	\N	t	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	TextTerminalUnit1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	3	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	32 x 16	\N	\N	\N	\N	\N	\N	\N	\N	TTU	\N	\N	\N	\N	WFS_TTU_FIXED	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_TTU	4
5	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	9
33	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	WFS_CIM_EXBYHAND	\N	NUMDEVICES=1 DEVICE1=UID=155,DEVNAME=CASH-01-UsbDispenser,DEVVAR=1 FirmwareVersion=0033	\N	\N	\N	\N	\N	f	\N	f	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	CurrencyDispenser1	\N	\N	\N	\N	40	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_CDM_RA_STACKER  WFS_CDM_RA_REJECT	\N	\N	WFS_CDM_PRESENT  WFS_CDM_REJECT	WFS_CDM_NOTSUPP	\N	\N	CDM	t	\N	WFS_CDM_POSFRONT	\N	WFS_CDM_SELFSERVICEBILL	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_CDM	36
7	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PTR_ASCII	\N	\N	\N	0	f	\N	WFS_PTR_CTRLFLUSH	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	NUMDEVICES=1 DEVICE1=UID=14,DEVNAME=JPNT-01-PcThermal,DEVVAR=1	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	0	0	\N	\N	\N	\N	\N	JournalPrinter1	\N	\N	\N	\N	\N	0	\N	\N	0	f	\N	\N	f	\N	\N	WFS_PTR_PAPERUPPER	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	WFS_PTR_RESLOW	\N	\N	0	\N	\N	\N	\N	\N	JPTR	\N	\N	\N	\N	WFS_PTR_TYPEJOURNAL	\N	\N	WFS_PTR_WRITETEXT	\N	\N	WFS_SERVICE_CLASS_PTR	1
6	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	12
28	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	29
32	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_TTU_ASCII	\N	\N	\N	\N	\N	\N	\N	t	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=1 DEVICE1=UID=125,DEVNAME=OPP_-01-USBUOP,DEVVAR=1	\N	\N	t	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	TextTerminalUnit1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	3	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	32 x 16	\N	\N	\N	\N	\N	\N	\N	\N	TTU	\N	\N	\N	\N	WFS_TTU_FIXED	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_TTU	32
37	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_DEP_ASCII	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=2 DEVICE1=UID=126,DEVNAME=DEP_-01-USBDepository,DEVVAR=2 DEVICE2=UID=127,DEVNAME=ENV_-01-USBEnvelopeDispenser,DEVVAR=1 FirmwareVersion=0015	\N	\N	\N	\N	\N	\N	\N	t	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Envelope1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	DEP	\N	\N	\N	\N	WFS_DEP_TYPEENVELOPE	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_DEP	35
42	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_DEP_ASCII	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=2 DEVICE1=UID=126,DEVNAME=DEP_-01-USBDepository,DEVVAR=2 DEVICE2=UID=127,DEVNAME=ENV_-01-USBEnvelopeDispenser,DEVVAR=1 	\N	\N	\N	\N	\N	\N	\N	t	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	Envelope1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	DEP	\N	\N	\N	\N	WFS_DEP_TYPEENVELOPE	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_DEP	31
38	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	27
18	\N	\N	\N	\N	\N	\N	\N	\N	10	\N	\N	\N	\N	\N	\N	\N	\N	WFS_IDC_CHIPPOWERCOLD  WFS_IDC_CHIPPOWERWARM  WFS_IDC_CHIPPOWEROFF	WFS_IDC_CHIPT0  WFS_IDC_CHIPT1	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=1 DEVICE1=UID=107,DEVNAME=MCRW-01-RS232Motorised,DEVVAR=83 FirmwareVersion=02.93 SCFirmwareVersion=02493-01D EMV=1	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	IDCardUnit1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_IDC_EJECTTHENRETAIN	WFS_IDC_NOACTION	\N	\N	\N	\N	\N	WFS_IDC_TRACK1 WFS_IDC_TRACK2 WFS_IDC_TRACK3	t	\N	\N	\N	\N	\N	\N	\N	\N	WFS_IDC_SECNOTSUPP	\N	IDC	\N	\N	\N	\N	WFS_IDC_TYPEMOTOR	\N	\N	\N	WFS_IDC_LOCO	WFS_IDC_TRACK3	WFS_SERVICE_CLASS_IDC	15
12	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_CIM_EXBYHAND	\N	NUMDEVICES=1 DEVICE1=UID=120,DEVNAME=NACC-01-GBRU,DEVVAR=9 FirmwareVersion=AA61,EU6913	\N	\N	\N	\N	\N	f	t	f	t	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	BillAcceptor1	\N	\N	200	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	WFS_CIM_RA_RETRACT  WFS_CIM_RA_BILLCASSETTES	\N	\N	WFS_CIM_NOTSUPP	WFS_CIM_NOTSUPP	\N	\N	GBRU-GBNA	t	\N	WFS_CIM_POSINFRONT WFS_CIM_POSOUTFRONT	\N	WFS_CIM_SELFSERVICEBILL	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_CIM	18
43	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PTR_ASCII	\N	\N	\N	0	f	\N	WFS_PTR_CTRLFLUSH	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	NUMDEVICES=1 DEVICE1=UID=14,DEVNAME=JPNT-01-PcThermal,DEVVAR=1	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	0	0	\N	\N	\N	\N	\N	JournalPrinter1	\N	\N	\N	\N	\N	0	\N	\N	0	f	\N	\N	f	\N	\N	WFS_PTR_PAPERUPPER	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	WFS_PTR_RESLOW	\N	\N	0	\N	\N	\N	\N	\N	JPTR	\N	\N	\N	\N	WFS_PTR_TYPEJOURNAL	\N	\N	WFS_PTR_WRITETEXT	\N	\N	WFS_SERVICE_CLASS_PTR	44
11	f	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PTR_ASCII	\N	\N	\N	0	f	\N	WFS_PTR_CTRLEJECT  WFS_PTR_CTRLCUT  WFS_PTR_CTRLFLUSH	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	NUMDEVICES=1 DEVICE1=UID=15,DEVNAME=RPNT-01-PcThermal,DEVVAR=12	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	0	0	\N	\N	\N	\N	\N	ReceiptPrinter1	\N	\N	\N	\N	\N	0	\N	\N	0	f	\N	\N	f	\N	\N	WFS_PTR_PAPERUPPER	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	WFS_PTR_RESLOW	\N	\N	0	\N	\N	\N	\N	\N	RPTR	\N	\N	\N	\N	WFS_PTR_TYPERECEIPT	\N	\N	WFS_PTR_WRITETEXT	\N	\N	WFS_SERVICE_CLASS_PTR	10
47	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	48
30	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	38
4	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	6
35	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	42
13	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	2
27	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	28
1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_CIM_EXBYHAND	\N	NUMDEVICES=1 DEVICE1=UID=100,DEVNAME=NACC-01-RS232Bunch,DEVVAR=1 FirmwareVersion=T044  K017  E009  G003 ,MBV-A C0129 D0307 V05 F02 P06 TemplateInfo=BV Type = MBV (ABV mode),BV Control: 0129,BV DL/DSP: 0307,BV Version: 05,BV Format: 02,BV PLD: 06,1. Country = 37 Denom = 1 Version = 42,2. Country = 37 Denom = 2 Version = 42,3. Country = 37 Denom = 3 Version = 42,4. Country = 37 Denom = 4 Version = 42,5. Country = 37 Denom = 5 Version = 42,6. Country = 37 Denom = 6 Version = 42,7. Country = 37 Denom = 7 Version = 42	\N	\N	\N	\N	\N	f	t	f	t	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	CashInModule1	\N	\N	50	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	WFS_CIM_RA_RETRACT  WFS_CIM_RA_BILLCASSETTES	\N	\N	WFS_CIM_NOTSUPP	WFS_CIM_NOTSUPP	\N	\N	CIM	t	\N	WFS_CIM_POSINFRONT WFS_CIM_POSOUTFRONT	\N	WFS_CIM_SELFSERVICEBILL	\N	\N	\N	\r	\N	WFS_SERVICE_CLASS_CIM	11
40	f	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PTR_ASCII  WFS_PTR_UNICODE	\N	\N	\N	0	f	\N	WFS_PTR_CTRLEJECT  WFS_PTR_CTRLCUT  WFS_PTR_CTRLFLUSH	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	NUMDEVICES=1 DEVICE1=UID=138,DEVNAME=RPNT-01-UsbThermal,DEVVAR=2 FirmwareVersion=07.15.00.00,04.10.00.00,00.90.00.00 TWO_SIDED_HARDWARE=TRUE	\N	\N	\N	0	\N	\N	\N	\N	t	\N	\N	\N	0	0	\N	\N	\N	\N	\N	USBReceiptPrinter1	\N	\N	\N	\N	\N	0	\N	\N	0	\N	\N	\N	f	\N	\N	WFS_PTR_PAPERUPPER	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	WFS_PTR_RESLOW	\N	\N	0	\N	\N	\N	\N	\N	URPTR	\N	\N	\N	\N	WFS_PTR_TYPERECEIPT	\N	\N	WFS_PTR_WRITETEXT  WFS_PTR_WRITEGRAPHICS  WFS_PTR_WRITEBARCODE	\N	\N	WFS_SERVICE_CLASS_PTR	26
51	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	53
53	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	55
49	f	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PTR_ASCII	\N	\N	\N	0	f	\N	WFS_PTR_CTRLEJECT  WFS_PTR_CTRLCUT  WFS_PTR_CTRLFLUSH	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	0	NUMDEVICES=1 DEVICE1=UID=15,DEVNAME=RPNT-01-PcThermal,DEVVAR=12	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	0	0	\N	\N	\N	\N	\N	ReceiptPrinter1	\N	\N	\N	\N	\N	0	\N	\N	0	f	\N	\N	f	\N	\N	WFS_PTR_PAPERUPPER	\N	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	WFS_PTR_RESLOW	\N	\N	0	\N	\N	\N	\N	\N	RPTR	\N	\N	\N	\N	WFS_PTR_TYPERECEIPT	\N	\N	WFS_PTR_WRITETEXT	\N	\N	WFS_SERVICE_CLASS_PTR	51
10	\N	WFS_PIN_CRYPTDESECB  WFS_PIN_CRYPTDESCBC  WFS_PIN_CRYPTDESMAC	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	0	\N	WFS_PIN_DISPNONE	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=1 DEVICE1=UID=99,DEVNAME=KEYB-01-SdcEPPB,DEVVAR=162 Vendor=NCR Encryptor=EPP-B FirmwareVersion=DAPI118 AUTOBEEP=1 	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	0	\N	100	Pinpad1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PIN_FORM3624  WFS_PIN_FORMANSI  WFS_PIN_FORMISO0  WFS_PIN_FORMISO1  WFS_PIN_FORMECI2  WFS_PIN_FORMECI3  WFS_PIN_FORMVISA  	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	PIN	\N	\N	\N	\N	WFS_PIN_TYPEEPP  WFS_PIN_TYPEEDM  WFS_PIN_TYPEHSM	WFS_PIN_DES  WFS_PIN_VISA	\N	\N	\N	\N	WFS_SERVICE_CLASS_PIN	3
2	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	5
8	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	16
14	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	13
15	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	14
16	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	17
29	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	33
31	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	41
44	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	45
46	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	47
48	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	50
50	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	52
52	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=8 DEVICE1=UID=5,DEVNAME=MEI_-01-SdcMediaEntryIndicators,DEVVAR=0 DEVICE2=UID=7,DEVNAME=ALRM-01-SdcAlarms,DEVVAR=0 DEVICE3=UID=8,DEVNAME=FLT_-01-SdcFasciaLight,DEVVAR=0 DEVICE4=UID=9,DEVNAME=ISI_-01-SdcInServiceIndicator,DEVVAR=0 DEVICE5=UID=10,DEVNAME=RSI_-01-SdcRemoteStatusInd,DEVVAR=0 DEVICE6=UID=11,DEVNAME=RRLY-01-SdcRemoteRelay,DEVVAR=0 DEVICE7=UID=23,DEVNAME=MDSW-01-MODESWITCH,DEVVAR=0 DEVICE8=UID=172,DEVNAME=ALRM-01-UsbFraudDetection,DEVVAR=0 FirmwareVersion=009-0009614,7.3.3.0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	SIU	\N	\N	\N	\N	WFS_SIU_SENSORS  WFS_SIU_INDICATORS  WFS_SIU_AUXILIARIES  WFS_SIU_GUIDLIGHTS	\N	\N	\N	\N	\N	SIU	54
41	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	3	2	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	WFS_CIM_EXBYHAND	\N	NUMDEVICES=1 DEVICE1=UID=17,DEVNAME=CASH-01-SdcDispenser,DEVVAR=1 FirmwareVersion=009-0023831,0.0.0.0	\N	\N	\N	\N	\N	f	\N	f	t	\N	\N	\N	\N	\N	\N	1	\N	\N	\N	CurrencyDispenser1	\N	\N	\N	\N	40	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_CDM_RA_STACKER  WFS_CDM_RA_REJECT	\N	\N	WFS_CDM_PRESENT  WFS_CDM_REJECT	WFS_CDM_NOTSUPP	\N	\N	CDM	t	\N	WFS_CDM_POSFRONT	\N	WFS_CDM_SELFSERVICEBILL	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_CDM	49
39	\N	WFS_PIN_CRYPTDESECB  WFS_PIN_CRYPTDESCBC  WFS_PIN_CRYPTDESMAC  WFS_PIN_CRYPTTRIDESECB  WFS_PIN_CRYPTTRIDESCBC  WFS_PIN_CRYPTTRIDESMAC	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	0	f	WFS_PIN_DISPNONE	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=1 DEVICE1=UID=152,DEVNAME=KEYB-01-USBEPP2,DEVVAR=35 Vendor=NCR Encryptor=EPP-USB-2 FirmwareVersion=LGCY_22 AUTOBEEP=0 	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	WFS_PIN_KCVZERO	\N	\N	Pinpad1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PIN_FORMDIEBOLD  WFS_PIN_FORMVISA3  WFS_PIN_FORMISO3	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	PIN	\N	\N	\N	\N	WFS_PIN_TYPEEPP  WFS_PIN_TYPEEDM  WFS_PIN_TYPEHSM	WFS_PIN_DES  WFS_PIN_VISA	\N	\N	\N	\N	WFS_SERVICE_CLASS_PIN	39
45	\N	WFS_PIN_CRYPTDESECB  WFS_PIN_CRYPTDESCBC  WFS_PIN_CRYPTDESMAC	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	0	\N	WFS_PIN_DISPNONE	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=1 DEVICE1=UID=99,DEVNAME=KEYB-01-SdcEPPB,DEVVAR=162 Vendor=NCR Encryptor=EPP-B FirmwareVersion=DAPI118 AUTOBEEP=1 	\N	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	0	\N	100	Pinpad1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_PIN_FORM3624  WFS_PIN_FORMANSI  WFS_PIN_FORMISO0  WFS_PIN_FORMISO1  WFS_PIN_FORMECI2  WFS_PIN_FORMECI3  WFS_PIN_FORMVISA  	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	PIN	\N	\N	\N	\N	WFS_PIN_TYPEEPP  WFS_PIN_TYPEEDM  WFS_PIN_TYPEHSM	WFS_PIN_DES  WFS_PIN_VISA	\N	\N	\N	\N	WFS_SERVICE_CLASS_PIN	46
36	\N	\N	\N	\N	\N	\N	\N	\N	10	\N	\N	\N	\N	\N	\N	\N	\N	WFS_IDC_CHIPPOWERCOLD  WFS_IDC_CHIPPOWERWARM  WFS_IDC_CHIPPOWEROFF	WFS_IDC_CHIPT0  WFS_IDC_CHIPT1	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	NUMDEVICES=1 DEVICE1=UID=137,DEVNAME=MCRW-01-USBMotorised,DEVVAR=72 FirmwareVersion=03.40 SCFirmwareVersion=02493-01E EMV=1	f	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	IDCardUnit1	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_IDC_NOACTION	WFS_IDC_NOACTION	\N	\N	\N	\N	\N	WFS_IDC_TRACK1  WFS_IDC_TRACK2  WFS_IDC_TRACK3	f	\N	\N	\N	\N	\N	\N	\N	\N	WFS_IDC_SECNOTSUPP	\N	IDC	\N	\N	\N	\N	WFS_IDC_TYPEMOTOR	\N	\N	\N	WFS_IDC_LOCO  WFS_IDC_HICO	WFS_IDC_TRACK1  WFS_IDC_TRACK2  WFS_IDC_TRACK3	WFS_SERVICE_CLASS_IDC	34
34	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	3	2	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	\N	\N	f	\N	\N	\N	\N	\N	\N	WFS_CIM_EXBYHAND	\N	NUMDEVICES=1 DEVICE1=UID=17,DEVNAME=CASH-01-SdcDispenser,DEVVAR=1 FirmwareVersion=009-0023831,0.0.0.0	\N	\N	\N	\N	\N	f	\N	f	t	\N	\N	\N	\N	\N	\N	1	\N	\N	\N	CurrencyDispenser1	\N	\N	\N	\N	40	\N	\N	\N	\N	\N	\N	0	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	\N	WFS_CDM_RA_STACKER  WFS_CDM_RA_REJECT	\N	\N	WFS_CDM_PRESENT  WFS_CDM_REJECT	WFS_CDM_NOTSUPP	\N	\N	CDM	t	\N	WFS_CDM_POSFRONT	\N	WFS_CDM_SELFSERVICEBILL	\N	\N	\N	\N	\N	WFS_SERVICE_CLASS_CDM	7
\.


--
-- Name: xfs_components_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('xfs_components_id_seq', 42, true);


--
-- Name: financial_devices_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY financial_devices
    ADD CONSTRAINT financial_devices_pkey PRIMARY KEY (id);


--
-- Name: hardware_devices_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hardware_devices
    ADD CONSTRAINT hardware_devices_pkey PRIMARY KEY (id);


--
-- Name: hotfixes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY hotfixes
    ADD CONSTRAINT hotfixes_pkey PRIMARY KEY (id);


--
-- Name: internet_explorers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internet_explorers
    ADD CONSTRAINT internet_explorers_pkey PRIMARY KEY (id);


--
-- Name: logical_cash_units_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY logical_cash_units
    ADD CONSTRAINT logical_cash_units_pkey PRIMARY KEY (id);


--
-- Name: operating_systems_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY operating_systems
    ADD CONSTRAINT operating_systems_pkey PRIMARY KEY (id);


--
-- Name: operating_systems_serial_number_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY operating_systems
    ADD CONSTRAINT operating_systems_serial_number_key UNIQUE (serial_number);


--
-- Name: physical_cash_units_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY physical_cash_units
    ADD CONSTRAINT physical_cash_units_pkey PRIMARY KEY (id);


--
-- Name: queries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY queries
    ADD CONSTRAINT queries_pkey PRIMARY KEY (id);


--
-- Name: roles_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_name_key UNIQUE (name);


--
-- Name: roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: scheduled_updates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scheduled_updates
    ADD CONSTRAINT scheduled_updates_pkey PRIMARY KEY (id);


--
-- Name: software_aggregates_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY software_aggregates
    ADD CONSTRAINT software_aggregates_pkey PRIMARY KEY (id);


--
-- Name: software_identifying_number_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY software
    ADD CONSTRAINT software_identifying_number_key UNIQUE (identifying_number);


--
-- Name: software_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY software
    ADD CONSTRAINT software_pkey PRIMARY KEY (id);


--
-- Name: terminal_config_operating_system_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY t_config_op_system
    ADD CONSTRAINT terminal_config_operating_system_pkey PRIMARY KEY (terminal_config_id, operating_system_id);


--
-- Name: terminal_config_software_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_config_software
    ADD CONSTRAINT terminal_config_software_pkey PRIMARY KEY (terminal_config_id, software_id);


--
-- Name: terminal_configs_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_configs
    ADD CONSTRAINT terminal_configs_pkey PRIMARY KEY (id);


--
-- Name: terminal_internet_explorer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_internet_explorer
    ADD CONSTRAINT terminal_internet_explorer_pkey PRIMARY KEY (terminal_id, internet_explorer_id);


--
-- Name: terminal_software_aggregate_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_software_aggregate
    ADD CONSTRAINT terminal_software_aggregate_pkey PRIMARY KEY (terminal_id, software_aggregate_id);


--
-- Name: terminals_ip_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminals
    ADD CONSTRAINT terminals_ip_key UNIQUE (ip);


--
-- Name: terminals_mac_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminals
    ADD CONSTRAINT terminals_mac_key UNIQUE (mac);


--
-- Name: terminals_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminals
    ADD CONSTRAINT terminals_pkey PRIMARY KEY (id);


--
-- Name: unique_ie_version; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY internet_explorers
    ADD CONSTRAINT unique_ie_version UNIQUE (major_version, minor_version, build_version, revision_version, remaining_version);


--
-- Name: unique_monthkly_schedule; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scheduled_updates
    ADD CONSTRAINT unique_monthkly_schedule UNIQUE (hours, minutes, month_day);


--
-- Name: unique_sw_agg_name_version; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY software_aggregates
    ADD CONSTRAINT unique_sw_agg_name_version UNIQUE (name, major_version, minor_version, build_version, revision_version, remaining_version);


--
-- Name: unique_terminal_config_timestamp; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY terminal_configs
    ADD CONSTRAINT unique_terminal_config_timestamp UNIQUE (terminal_id, start_date);


--
-- Name: unique_weekly_schedule; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY scheduled_updates
    ADD CONSTRAINT unique_weekly_schedule UNIQUE (hours, minutes, week_day);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- Name: xfs_components_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY xfs_components
    ADD CONSTRAINT xfs_components_pkey PRIMARY KEY (id);


--
-- Name: financial_devices_terminal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY financial_devices
    ADD CONSTRAINT financial_devices_terminal_id_fkey FOREIGN KEY (terminal_id) REFERENCES terminals(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: hardware_devices_terminal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hardware_devices
    ADD CONSTRAINT hardware_devices_terminal_id_fkey FOREIGN KEY (terminal_id) REFERENCES terminals(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: hotfixes_terminal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hotfixes
    ADD CONSTRAINT hotfixes_terminal_id_fkey FOREIGN KEY (terminal_id) REFERENCES terminals(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: logical_cash_units_xfs_component_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY logical_cash_units
    ADD CONSTRAINT logical_cash_units_xfs_component_id_fkey FOREIGN KEY (xfs_component_id) REFERENCES xfs_components(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: physical_cash_units_logical_cash_unit_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY physical_cash_units
    ADD CONSTRAINT physical_cash_units_logical_cash_unit_id_fkey FOREIGN KEY (logical_cash_unit_id) REFERENCES logical_cash_units(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: queries_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY queries
    ADD CONSTRAINT queries_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;


--
-- Name: t_config_op_system_operating_system_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY t_config_op_system
    ADD CONSTRAINT t_config_op_system_operating_system_id_fkey FOREIGN KEY (operating_system_id) REFERENCES operating_systems(id);


--
-- Name: t_config_op_system_terminal_config_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY t_config_op_system
    ADD CONSTRAINT t_config_op_system_terminal_config_id_fkey FOREIGN KEY (terminal_config_id) REFERENCES terminal_configs(id);


--
-- Name: terminal_config_software_software_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_config_software
    ADD CONSTRAINT terminal_config_software_software_id_fkey FOREIGN KEY (software_id) REFERENCES software(id);


--
-- Name: terminal_config_software_terminal_config_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_config_software
    ADD CONSTRAINT terminal_config_software_terminal_config_id_fkey FOREIGN KEY (terminal_config_id) REFERENCES terminal_configs(id);


--
-- Name: terminal_configs_terminal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_configs
    ADD CONSTRAINT terminal_configs_terminal_id_fkey FOREIGN KEY (terminal_id) REFERENCES terminals(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: terminal_internet_explorer_internet_explorer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_internet_explorer
    ADD CONSTRAINT terminal_internet_explorer_internet_explorer_id_fkey FOREIGN KEY (internet_explorer_id) REFERENCES internet_explorers(id);


--
-- Name: terminal_internet_explorer_terminal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_internet_explorer
    ADD CONSTRAINT terminal_internet_explorer_terminal_id_fkey FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: terminal_software_aggregate_software_aggregate_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_software_aggregate
    ADD CONSTRAINT terminal_software_aggregate_software_aggregate_id_fkey FOREIGN KEY (software_aggregate_id) REFERENCES software_aggregates(id);


--
-- Name: terminal_software_aggregate_terminal_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY terminal_software_aggregate
    ADD CONSTRAINT terminal_software_aggregate_terminal_id_fkey FOREIGN KEY (terminal_id) REFERENCES terminals(id);


--
-- Name: users_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id) REFERENCES roles(id);


--
-- Name: xfs_components_financial_device_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY xfs_components
    ADD CONSTRAINT xfs_components_financial_device_id_fkey FOREIGN KEY (financial_device_id) REFERENCES financial_devices(id);


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

