import React from "react"
import { Container, Form, Button, Card } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import tripuraLogo from "./tripura_logo.png"
import rtiLogo from "./rti_logo.webp"

export default function LoginUIBootstrap() {
const navigate = useNavigate()

const handleLogin = (e) => {
e.preventDefault()
navigate("/RTIOnline/dashboard")
}

return (
<Container fluid className="bg-light min-vh-100 d-flex justify-content-center align-items-center">
<Card className="p-4 shadow" style={{ width: "100%", maxWidth: "420px" }}>
<div className="text-center mb-4">
<img src={tripuraLogo} alt="Tripura Logo" width={80} className="me-3" />
<img src={rtiLogo} alt="RTI Logo" width={80} />
</div>
<h4 className="text-center mb-4 fw-bold">Right to Information</h4>
<Form onSubmit={handleLogin}>
<Form.Group className="mb-3" controlId="formUsername">
<Form.Label>Username</Form.Label>
<Form.Control type="text" placeholder="Enter username" required />
</Form.Group>
      <Form.Group className="mb-4" controlId="formPassword">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Enter password" required />
      </Form.Group>

      <div className="d-grid">
        <Button variant="primary" type="submit">Login</Button>
      </div>
    </Form>
  </Card>
</Container>
)}