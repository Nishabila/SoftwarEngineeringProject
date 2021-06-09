

	<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		
	    $product_name = $_POST['product_name'];
		$product_color = $_POST['product_color'];
		$product_price = $_POST['product_price'];
		$product_description = $_POST['product_description'];
		$Product_photo = $_POST['Product_photo'];
    
		
	require_once('db_connect.php');

		$path = "product_image/$product_name .jpg";
		
		$actualpath = "https://almuhtazibah.000webhostapp.com/$path";
		
		//http://stamasoft.com/android//volley_image_rnd/$path
		
		//http://10.0.2.2:8012/Volley_image_upload
		
		$sql ="INSERT INTO `product_details`(`product_name`, `product_color`, `product_price`, `product_description`, `Product_photo`)
             			VALUES ('$product_name','$product_color','$product_price','$product_description','$actualpath')";	  

		
		//$sql = "INSERT INTO images (photo,name) VALUES ('$actualpath','$name')";
		
		if(mysqli_query($con,$sql)){
			file_put_contents($path,base64_decode(	$Product_photo));
			echo "Successfully Uploaded";
		}
		
		mysqli_close($con);
	}else{
		echo "Error";
	}