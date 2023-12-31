import React, { useState, useEffect } from 'react'
import { deleteDepartment, listDepartments } from '../services/DepartmentService';
import { Link, useNavigate } from 'react-router-dom';

const ListDepartmentComponent = () => {

    const [departments, setDepartments] = useState([]);
    const navigator = useNavigate();
    useEffect(() =>{
        listOfDepartments();
    }, []);

    function listOfDepartments(){
        listDepartments()?.then((response)=>{
            console.log(response.data);
            setDepartments(response.data);
        }).catch(error =>{
            console.error(error);
        });
    }

    function updateDepartment(id){
        navigator(`/edit-department/${id}`)
    }

    function removeDepartment(id){
        deleteDepartment(id).then((response)=>{
            console.log(response.data);
            listOfDepartments();
        }).catch(error =>{
            console.error(error);
        });
    }
  return (
    <div className='container'>

        <h2 className='text-center'><p>List of Departments</p></h2>
        <Link className='btn btn-primary mb-2' to='/add-department'>Add Department</Link>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Department Id</th>
                    <th>Department Name</th>
                    <th>Department Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    departments.map(department => 
                        <tr key={department.id}>
                            <td>{department.id}</td>
                            <td>{department.departmentName}</td>
                            <td>{department.departmentDescription}</td>
                            <td>
                                <button className='btn btn-info' onClick={() => updateDepartment(department.id)}>Update</button>
                                <button className='btn btn-danger' onClick={() => removeDepartment(department.id)} style={{marginLeft: '10px'}}>Delete</button>
                            </td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListDepartmentComponent