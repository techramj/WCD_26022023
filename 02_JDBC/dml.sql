   insert into users (user_id, username, password,first_name, last_name , email)
   values (1,'jackj','123','Jack','Johnson','jack@test.com');
   
   insert into users (user_id, username, password,first_name, last_name , email)
   values (2,'johns','123','John','Shina','john@test.com');
   
   insert into users (user_id, username, password,first_name, last_name , email)
   values (3,'sam','123','Sammer','Kanetkar','sam@test.com');
   
   commit;
   
   --update password
   update users set password='abc' where user_id = 3;
   
   --delete user
   delete from users where user_id = 2; 
   
   
  /*
   Create
   Read
   Update
   Delete
   
  */
   
   
   