<?php 
 //Getting Id
 //$id = $_GET['p_id'];
 
  if($_SERVER['REQUEST_METHOD']=='POST'){
 $cart_id= $_POST['cart_id'];
 //Importing database
 require_once('db_connect.php');

 //Creating sql query
 $sql = "DELETE FROM cart WHERE cart_id=$cart_id;";
 
 //Deleting record in database 
 if(mysqli_query($con,$sql)){
 echo 'Item Deleted Successfully';
 }else{
 echo 'Could Not Delete  Try Again';
 }

 //closing connection 
 mysqli_close($con);
  }