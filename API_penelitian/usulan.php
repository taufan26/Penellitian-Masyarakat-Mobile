<?php
include 'config.php';

if ($_GET) {
	
	//data
	$user_id = $_GET['user_id'] ?? '';

	$response = [];//data response

	//cek username didalam database
	$userQuery = $connection->prepare("SELECT * FROM  where user_email = ?");
	$userQuery->execute(array($email));
	$query = $userQuery->fetch();

	if ($userQuery->rowCount() == 0) {
		$response['status'] = false;
		$response['message'] = "Email Tidak Terdaftar";
	} else {
		//ambil password di db

		$passwordDB = $query['user_password'];

		if (strcmp(md5($password), $passwordDB) === 0) {
			$response['status'] = true;
			$response['message'] = "Login Berhasil";
			$response['data'] = [
				'user_id' => $query['user_id'],
				'user_email' => $query['user_email'],
				'user_name' => $query['user_name'],
				'user_role' => $query['user_role'],
				'user_nidn' => $query['user_nidn'],
				'user_image' => $query['user_image']
			];
		}else{
			$response['status'] = false;
			$response['message'] = "Password anda salah";
		}
	}

	//data json
	$json = json_encode($response, JSON_PRETTY_PRINT);

	echo $json;
	
}

?>