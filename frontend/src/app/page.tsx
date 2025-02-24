"use client";

import "./globals.css";
import { NavbarWithMegaMenu } from "./components/NavBar";

export default function Home() {
  return (
    <>
      <div className="grid grid-rows-[auto_1fr_auto] min-h-screen">
        <header>
          <NavbarWithMegaMenu />
        </header>

        <main className="p-8 pb-20 gap-16 sm:p-20">
          <ol></ol>
        </main>

        <footer className="text-center p-4"></footer>
      </div>
    </>
  );
}
