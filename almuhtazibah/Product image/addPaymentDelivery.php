<?php 
 
 
 //Getting values
 $Payment_method = $_POST['Payment_method'];

 $Order_id = $_POST['Order_id'];

 $Delivery_method= $_POST['Delivery_method'];
  $Description= $_POST['Description'];
 
  

  //Importing our db connection scripts
 require_once('db_connect.php');
 
   
 //Creating an sql query
 $sql_u = " INSERT INTO  delivery_system (Delivery_method,Order_id,Description) VALUES ('$Delivery_method','$Order_id','$Description')";

 $sql_i = " INSERT INTO  payment_system (Payment_method,Order_id) VALUES ('$Payment_method','$Order_id')";

 //Executing query to database
 if(mysqli_query($con, $sql_u) and mysqli_query($con, $sql_i)){
 echo 'Successfull';
 }else{
 echo 'Error';
 }

 //Closing the database 
 mysqli_close($con);
 