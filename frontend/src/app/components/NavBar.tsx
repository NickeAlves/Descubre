"use client";

import Link from "next/link";
import { usePathname } from "next/navigation";
import { Menu, X } from "lucide-react";
import { useState } from "react";
import "./../styles/globals.css";

const NavLinks = () => {
  const pathname = usePathname();

  return (
    <>
      <Link
        href="/"
        className={`font-sans px-4 py-2 rounded-full transition-colors ${
          pathname === "/"
            ? "bg-red-500 text-white"
            : "text-white hover:bg-red-400"
        }`}
      >
        Home
      </Link>
      <Link
        href="/cities"
        className={`font-sans px-4 py-2 rounded-full transition-colors ${
          pathname === "/cities"
            ? "bg-red-500 text-white"
            : "text-white hover:bg-red-400"
        }`}
      >
        Cities
      </Link>
      <Link
        href="/attractions"
        className={`font-sans px-4 py-2 rounded-full transition-colors ${
          pathname === "/attractions"
            ? "bg-red-500 text-white"
            : "text-white hover:bg-red-400"
        }`}
      >
        Attractions
      </Link>
    </>
  );
};

const NavBar = () => {
  const [isOpen, setIsOpen] = useState(false);

  const toggleNavBar = () => {
    setIsOpen(!isOpen);
  };

  return (
    <>
      <nav className="bg-transparent flex w-1/3 justify-end">
        <div className="pr-24 gap-4 hidden justify-between md:flex">
          <NavLinks />
        </div>
        <div className="md:hidden">
          <button onClick={toggleNavBar} className="text-white">
            {isOpen ? <X /> : <Menu />}
          </button>
        </div>
      </nav>
      {isOpen && (
        <div className="flex basis-full flex-col items-center p-2">
          <NavLinks />
        </div>
      )}
    </>
  );
};

export default NavBar;
