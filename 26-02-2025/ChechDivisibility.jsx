import { useState } from "react";

export default function DivisibilityChecker() {
  const [num, setNum] = useState("");
  const [message, setMessage] = useState("");

  const checkDivisibility = () => {
    setMessage(num % 16 === 0 ? `${num} is divisible by 16` : `${num} is not divisible by 16`);
  };

  return (
    <div>
      <input 
        type="number" 
        value={num} 
        onChange={(e) => setNum(e.target.value)} 
        placeholder="Enter a number"
      />
      <button onClick={checkDivisibility}>Check</button>
      <p>{message}</p>
    </div>
  );
}
