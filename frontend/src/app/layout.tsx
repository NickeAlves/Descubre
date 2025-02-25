import type { Metadata } from "next";
import "./styles/globals.css";
import ScrollToTopButton from "./components/ScrollToTopButton";
import Header from "./components/Header";
import Footer from "./components/Footer";

export const metadata: Metadata = {
  title: "Descubre",
  description: "Descubre.com, a page dedicated to tourism.",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <head>
        <link rel="icon" href="/images/circle-logo.png" />
      </head>
      <body>
        <Header />
        {children}
        <ScrollToTopButton />
        <Footer />
      </body>
    </html>
  );
}
