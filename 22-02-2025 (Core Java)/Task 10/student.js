
let student = {
    name: "Priya",
    age: 21,
    course: "ECE",
    
    // Method to display student details
    displayInfo: function() {
        console.log(`Student Name: ${this.name}`);
        console.log(`Age: ${this.age}`);
        console.log(`Course: ${this.course}`);
    }
};

student.displayInfo();

// Step 2: Add a nested object and more functions
student.address = {
    city: "Chennai",
    zip: "637505"
};

student.updateAge = function(newAge) {
    this.age = newAge;
    console.log(`Updated Age: ${this.age}`);
};

student.getFullAddress = function() {
    console.log(`Address: ${this.address.city}, ZIP: ${this.address.zip}`);
};
student.updateAge(22);
student.getFullAddress();

// Step 3: Remove a property and a function
delete student.course; 
delete student.updateAge;
student.displayInfo();
student.getFullAddress();
console.log(student); 
