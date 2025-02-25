"use client";

import "./../styles/globals.css";

const Footer = () => {
  return (
    <>
      <footer className="bg-gray-700 w-full">
        <div className="flex flex-row items-center justify-center gap-12 h-6">
          <img src="./images/circle-logo.png" alt="logo" className="h-14" />
          <p className="text-center text-white font-sans font-bold">
            &copy; 2025 Descubre. All rights reserved.
          </p>
        </div>
      </footer>
    </>
  );
};

export default Footer;
