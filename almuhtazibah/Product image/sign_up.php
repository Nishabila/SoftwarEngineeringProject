<?php 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 
 //Getting values
 

  $Full_name = $_POST['Full_name'];

  $customer_email= $_POST['customer_email'];

  $Mobile_no= $_POST['Mobile_no'];
 
  $password= $_POST['password'];
 
  
  //Importing our db connection scripts
  require_once('db_connect.php');
  $sql_u = "SELECT * FROM sign_up WHERE customer_email='$customer_email'";
  $res_u = mysqli_query($con, $sql_u);
    
  if(mysqli_num_rows($res_u) > 0)
  {
    echo "Sorry... email already taken";    
  }
  else
  {
            
    $sql = " INSERT INTO  sign_up(Full_name,customer_email,Mobile_no,password) VALUES ('$Full_name','$customer_email','$Mobile_no','$password')";
    $results = mysqli_query($con,$sql);
    
      echo "success";
     
    }
 
 mysqli_close($con);
 }