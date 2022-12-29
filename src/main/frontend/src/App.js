import './App.css';
import React, { useState, useEffect, useCallback } from 'react';
import axios from 'axios';
import { useDropzone } from 'react-dropzone'


const Dropzone = ({ user }) => {

  const onDrop = useCallback(acceptedFiles => {
    const file = acceptedFiles[0];

    const formData = new FormData();
    formData.append("file", file);

    axios.post(
      `http://localhost:8080/api/v1/user-profiles/${user.userProfileId}/image/upload`,
      formData,
      {
        headers: {
          "Content-type": "multipart/form-data"
        }
      }
    ).then(() => {
      console.log("file uploaded successfully")
    })
      .catch(err => {
        console.log(err);
      });
  }, [])


  const { getRootProps, getInputProps, isDragActive } = useDropzone({ onDrop });

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the image here...</p> :
          <p>Drag 'n' drop profile image, or click to select profile image</p>
      }
    </div>
  )
}

const UserProfiles = () => {
  const [userProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/v1/user-profiles")
      .then(res => {
        setUserProfiles(res.data);
      });
  };

  useEffect(() => {
    fetchUserProfiles();
  }, [])

  return userProfiles.map((userProfile, index) => (
    <div key={index}>
      {userProfile.userProfileImageLink ? <img src={`http://localhost:8080/api/v1/user-profiles/${userProfile.userProfileId}/image/download`} /> : null}
      <br />
      <br />
      <h1>{userProfile.username}</h1>
      <p>{userProfile.userProfileId}</p>
      <Dropzone user={userProfile} />
      <br />
    </div>
  ))
}


function App() {
  return (
    <div className="App">
      <UserProfiles />
    </div>
  );
}

export default App;
