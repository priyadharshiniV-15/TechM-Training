export default function StudentList() {
  const students = [
    { id: 1, name: "Nancy", department: "Computer Science" },
    { id: 2, name: "Priya", department: "Electronics" },
    { id: 3, name: "Arul", department: "Mechanical" },
    { id: 4, name: "Pavi", department: "Civil" },
    { id: 5, name: "Shivangi", department: "Information Technology" }
  ];

  return (
    <div>
      <h2>Student List</h2>
      <ul>
        {students.map((student) => (
          <li key={student.id}>
            {student.name} - {student.department}
          </li>
        ))}
      </ul>
    </div>
  );
}
