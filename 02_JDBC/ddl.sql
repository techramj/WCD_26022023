-- create table users
  create table users
  (user_id number primary key,
   username varchar2(20) unique,
   password varchar2(20),
   first_name varchar2(20),
   last_name varchar2(20),
   email varchar2(20)
   );
  
   

   
  