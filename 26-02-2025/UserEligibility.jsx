import { useState } from "react";

export default function CardChecker() {
  const [hasAadhar, setHasAadhar] = useState(false);
  const [hasPAN, setHasPAN] = useState(false);
  const [message, setMessage] = useState("");

  const checkEligibility = () => {
    const availableCards =
      (hasAadhar && hasPAN && "Aadhar Card and PAN Card") ||
      (hasAadhar && "Aadhar Card") ||
      (hasPAN && "PAN Card");

    setMessage(availableCards ? `You have: ${availableCards}.` : "You do not have Aadhar or PAN card.");
  };

  return (
    <div>
      <h2>Government Offer Eligibility</h2>
      <label>
        <input type="checkbox" checked={hasAadhar} onChange={() => setHasAadhar(!hasAadhar)} />
        Aadhar Card
      </label>
      <br />
      <label>
        <input type="checkbox" checked={hasPAN} onChange={() => setHasPAN(!hasPAN)} />
        PAN Card
      </label>
      <br />
      <button onClick={checkEligibility}>Check</button>
      <p>{message}</p>
    </div>
  );
}
