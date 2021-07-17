<?php
include 'config.php';

if ($_POST) {
	
	//data
	$user_id = $_POST['user_id'] ?? '';

	$response = [];//data response

	//cek username didalam database
	$userQuery = $connection->prepare("SELECT * FROM anggota_penelitian where anggota_penelitian_user_id = ?");
	$userQuery->execute(array($user_id));
	$query = $userQuery->fetch();

	if ($userQuery->rowCount() == 0) {
		$response['status'] = false;
		$response['message'] = "Tidak ada Data Keanggotaan Harap Isi terlebih Dahulu!";
	} else {
		//ambil password di db

		$passwordDB = $query['anggota_penelitian_user_id'];

		if (strcmp($user_id, $passwordDB) === 0) {
			$response['status'] = true;
			$response['message'] = "Data Keanggotaan Berhasil Ditampilkan";
			$response['data'] = [
				'anggota_penelitian_id' => $query['anggota_penelitian_id'],
				'anggota_penelitian_user_id' => $query['anggota_penelitian_user_id'],
				'anggota_penelitian_penelitian_id' => $query['anggota_penelitian_penelitian_id'],
				'anggota_penelitian_role' => $query['anggota_penelitian_role'],
				'anggota_penelitian_tugas' => $query['anggota_penelitian_tugas'],
				'created_at' => $query['created_at'],
				'updated_at' => $query['updated_at']
			];
		}else{
			$response['status'] = false;
			$response['message'] = "Tidak ada Data Keanggotaan Harap Isi terlebih Dahulu";
		}
	}

	//data json
	$json = json_encode($response, JSON_PRETTY_PRINT);

	echo $json;
	
}

?>