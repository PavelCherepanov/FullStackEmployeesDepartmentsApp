import './App.css'

import ListEmployeesComponent from './components/ListEmployeesComponent'
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import EmployeeComponent from './components/EmployeeComponent';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import ListDepartmentComponent from './components/ListDepartmentComponent';
import DepartmentComponent from './components/DepartmentComponent';


function App() {
  return (
    <>
    <BrowserRouter>
      <HeaderComponent/>
      <Routes>
        <Route path='/' element={<ListEmployeesComponent/>}></Route>
        <Route path='/employees' element={<ListEmployeesComponent/>}></Route>
        <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
        <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>

        <Route path='/departments' element={<ListDepartmentComponent/>}></Route>
        <Route path='/add-department' element={<DepartmentComponent/>}></Route>
        <Route path='/edit-department/:id' element={<DepartmentComponent/>}></Route>
      </Routes>
      <FooterComponent/>
    </BrowserRouter>
    </>
  )
}

export default App
