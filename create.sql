create sequence id_generator start with 1 increment by 50;
create table department (id bigint not null, created_date timestamp, last_modified_date timestamp, version bigint, department_head varchar(255), department_code varchar(255), department_id varchar(10), department_name varchar(255), primary key (id));
create table employee (id bigint not null, created_date timestamp, last_modified_date timestamp, version bigint, address varchar(255), dob date, employee_id varchar(10), name varchar(255), pan varchar(10), dept_id bigint, primary key (id));
alter table employee add constraint UK_mc5x07dj0uft9opsxchp0uwji unique (employee_id);
alter table employee add constraint FKaqchbcb8i6nvtl9g6c72yba0p foreign key (dept_id) references department;
