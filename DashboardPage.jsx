
import React from "react";

const DashboardPage = () => {
  // Example navigation handler
  const handleNavigate = (path) => {
    console.log("Navigate to:", path);
    // React-router here: navigate(path)
  };

  return (
    <div style={styles.container}>
      <div style={styles.card}>
        <h2 style={styles.title}>Dashboard</h2>
        <p style={styles.subtitle}>Welcome! Select an option below:</p>
        <div style={styles.buttonsContainer}>
          <button
            style={styles.button}
            onClick={() => handleNavigate("/requests")}
          >
            List of Requests
          </button>
          <button
            style={styles.button}
            onClick={() => handleNavigate("/details")}
          >
            Request Details
          </button>
          <button
            style={styles.button}
            onClick={() => handleNavigate("/logout")}
          >
            Logout
          </button>
        </div>
      </div>
    </div>
  );
};

const styles = {
  container: {
    minHeight: "100vh",
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "#f3f4f6",
    padding: "1rem",
  },
  card: {
    backgroundColor: "#ffffff",
    borderRadius: "0.5rem",
    boxShadow: "0 2px 8px rgba(0,0,0,0.1)",
    padding: "2rem",
    maxWidth: "500px",
    width: "100%",
  },
  title: {
    textAlign: "center",
    marginBottom: "1rem",
    fontSize: "1.75rem",
    fontWeight: "600",
  },
  subtitle: {
    textAlign: "center",
    marginBottom: "2rem",
    fontSize: "1rem",
    color: "#555",
  },
  buttonsContainer: {
    display: "flex",
    flexDirection: "column",
    gap: "1rem",
  },
  button: {
    padding: "0.75rem",
    backgroundColor: "#2563eb",
    color: "#ffffff",
    fontSize: "1rem",
    border: "none",
    borderRadius: "0.375rem",
    cursor: "pointer",
  },
};

export default DashboardPage;
