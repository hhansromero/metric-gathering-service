import React from 'react'

const Companies = ({ companies }) => {
  return (
    <div>
      <center><h1>Company List</h1></center>
      {companies.map((company) => (
        <div class="card">
          <div class="card-body">
            <p class="card-subtitle mb-2 text-muted">Company Id: {company.id}</p>
            <p class="card-subtitle mb-2 text-muted">Name: {company.name}</p>
            <p class="card-subtitle mb-2 text-muted">Ruc: {company.ruc}</p>
            <p class="card-subtitle mb-2 text-muted">Image: {company.image}</p>
          </div>
        </div>
      ))}
    </div>
  )
};

export default Companies