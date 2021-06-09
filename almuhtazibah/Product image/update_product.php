
<?php 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 
       $product_name = $_POST['product_name'];
		$product_color = $_POST['product_color'];
		$product_price = $_POST['product_price'];
		$product_description = $_POST['product_description'];
		$Product_photo = $_POST['Product_photo'];
    

  //Importing our db connection script
 require_once('db_connect.php');
 
 
 
  $filename="IMG".rand().".jpg";
	   file_put_contents("product_image/".$filename,base64_decode($Product_photo));

			$sql = "UPDATE `product_details` SET `product_name`='$product_name ',`product_color`='$product_color',`product_price`='$product_price',
			        `product_description`='$product_description',`Product_photo`='$filename'WHERE product_id = $product_id";

 //Updating database table 
 if(mysqli_query($con,$sql)){
 echo ' Updated Successfully';
 }else{
 echo 'Could Not Update  Try Again';
 }
 
 //closing connection 
 mysqli_close($con);
 }