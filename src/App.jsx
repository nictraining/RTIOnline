import RequestList from './pages/RequestList';

import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Home from './Home';
import FirstAppeal from './FirstAppeal';

import ScrollToTopButton from './components/ScrollToTopButton';
import HelpdeskSupportButton from './components/HelpdeskSupportButton';
import TopBar from './components/TopBar';
import Header from './components/Header';
import Footer from './components/Footer';
import BottomBar from './components/BottomBar';
import SubmitRequest from './SubmitRequest';
import ViewStatus from './ViewStatus';
import Header from './pages/Header';
import TopNavBar from './pages/TopNavBar';
import Index from './pages/Login';
import './pages/Login.css';
import Dashboard from './pages/Dashboard';
import RecordsNewRequest from './pages/RecordsNewRequest';
import Assessment from './pages/assessment';
import Footer from './pages/Footer';
import Guidelines from './Guidelines';

export default function App() {
  const [active, setActive] = useState('new');

  return (
    <>
      <TopBar />
      <Header />
      <TopNavBar /> 
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/first-appeal" element={<FirstAppeal />} />
        <Route path="/submit-rti" element={<SubmitRequest />} />
        <Route path="view-status" element={<ViewStatus />} />
        <Route path="/" element={<Index />} />
        <Route path="/Dashboard" element={<Dashboard />} />
        <Route path="/records" element={<RecordsNewRequest />} />
        <Route path="/assessment" element={<Assessment />} />
        <Route path="/rti-requests" element={<RequestList />} />
        <Route path="/guidelines" element={<Guidelines />} />
      </Routes>

      <Footer />
      <BottomBar />
      <ScrollToTopButton />
      <HelpdeskSupportButton />
    </>
  );
}
