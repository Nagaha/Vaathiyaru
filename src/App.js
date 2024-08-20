
import React, { useState, useEffect } from 'react';
import './styles.css'; // Import your CSS file for styling

function Listing({ tutor }) {
  return (
    <div className="listing">
      <h3>{tutor.heading}</h3>
      <p>{tutor.desc}</p>
      <p className="location">Location: {tutor.location}</p>
      <p>Experience: {tutor.exp}</p>
      <p>Ratings: {tutor.ratings}</p>
    </div>
  );
}

function ListingsGrid({ tutors }) {
  return (
    <div className="listings-grid">
      {tutors.map(tutor => (
        <Listing
          key={tutor.id}
          tutor={tutor}
        />
      ))}
    </div>
  );
}

export default function App() {
  const [tutors, setTutors] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/Services/showAvailable')
      .then(response => response.json())
      .then(data => setTutors(data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div className="app">
      <h1>Tutor Listings</h1>
      {tutors.length > 0 ? (
        <ListingsGrid tutors={tutors} />
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
}