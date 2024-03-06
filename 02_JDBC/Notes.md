# Type of driver
1. Type-1 driver or JDBC-ODBC bridge driver
2. Type-2 driver or Native-API driver
3. Type-3 driver or Network Protocol driver
4. Type-4 driver or Thin driver


## Tight vs loose coupling
	//ArrayList vs LinkList
		List<String> list1 = new LinkedList<String>(); //loose coupling
		ArrayList<String> list2 = new ArrayList<String>(); //tight coupling
		
## step to connect to the database
  step 0: download and install the db on your system
  https://www.oicbasics.com/2020/01/download-oracle-database-11g-xe-express.html
  https://www.oracle.com/database/technologies/xe-prior-release-downloads.html
  
  after installation, open the sql command line
  conn system/<password>
  
  alter user hr identified by hr account unlock;
  
  # step 1: load the driver
  # step 2: get the connection object using url, username & pwd
  
  
  

	
  