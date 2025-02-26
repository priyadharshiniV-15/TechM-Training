import { useState } from "react";

export default function CardChecker() {
  const [hasAadhar, setHasAadhar] = useState(false);
  const [hasPAN, setHasPAN] = useState(false);
  const [message, setMessage] = useState("");

  const checkEligibility = () => {
    if (hasAadhar || hasPAN) {
      let availableCards = [];
      if (hasAadhar) availableCards.push("Aadhar Card");
      if (hasPAN) availableCards.push("PAN Card");

      setMessage(`You have: ${availableCards.join(" and ")}.`);
    } else {
      setMessage("You do not have Aadhar or PAN card.");
    }
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
