<?php 

 
 //Getting values
 $customer_email = $_POST['customer_email'];

 $PName = $_POST['PName'];

 $pprice= $_POST['pprice'];

 $psize= $_POST['psize'];

 $plength= $_POST['plength'];

 $pcolor= $_POST['pcolor'];


 $proof_detail= $_POST['proof_detail'];

  //Importing our db connection scripts
 require_once('db_connect.php');
  $sql = "SELECT User_id FROM  sign_up WHERE customer_email= '$customer_email'";
 
 //getting result 
 $r = mysqli_query($con,$sql);
 
 $count=mysqli_num_rows($r);


if($count>0){
 while ($row = $r->fetch_assoc()) {
  $ud = $row["User_id"];
}
  
 //Creating an sql query
 $sql_2 = " INSERT INTO  order_details (User_id,PName,pprice,psize,plength,pcolor,paid,proof_detail)VALUES ('$ud','$PName','$pprice','$psize','$plength','$pcolor','Pending','$proof_detail')";
  
 //Executing query to database
 if(mysqli_query($con,$sql_2)){
     
     $last_id = mysqli_insert_id($con);
  echo  $last_id;

 }else{
 echo 'Could Not Add Order';
 }
}
else
 echo 'wrong email';
 //Closing the database 
 mysqli_close($con);
 