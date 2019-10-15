create database automation_offrep;
use automation_offrep;
-- drop table tbl_translog_http;
-- http协议的交易报文经过netparser解析后的持久化报文
create table if not exists automation_offrep.tbl_translog_http(
    id string,
    conn_id string,
    sys_name string,
    request_seq string,
    request_begin_frame string,
    request_end_frame string,
    response_begin_frame string,
    response_end_frame string,
    idle_time0 int,
    request_begin_time string,
    request_end_time string,
    request_used_time int,
    response_begin_time string,
    response_end_time string,
    response_used_time int,
    idle_time1 int,
    user_agent string,
    connection string,
    cdn_src_ip string,
    x_forwarded_for string,
    x_forwarded_host string,
    x_forwarded_server string,
    request_trans_encode string,
    request_host string,
    request_type string,
    request_url string,
    request_protocol string,
    request_referer string,
    request_content_type string,
    request_charset string,
    request_header string,
    response_trans_encode string,
    response_code string,
    response_content_type string,
    response_content_encoding string,
    response_charset string,
    response_header string,
    request_payload string,
    response_payload string,
    request_size int,
    response_size int,
    deal_message string,
    file_name string,
    src_ip string,
    src_port string,
    dst_ip string,
    dst_port string,
    data_source string,
    domain string,
    exts string,
    rcv_ts string,
    system string,
    to_ts string,
    settle_date string
)
row format delimited
fields terminated by '\t'
stored as textfile;

