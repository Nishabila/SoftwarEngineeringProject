<?php 
$customer_email= $_POST['customer_email'];
$password= $_POST['password'];

 //Importing Database Script 
 require_once('db_connect.php');
 
 //Creating sql query
 $sql = "SELECT * FROM  sign_up WHERE customer_email='$customer_email' and password='$password'";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 $count=mysqli_num_rows($r);

if($count>0)
 echo "found";
else
 echo "Error";
 mysqli_close($con);
  