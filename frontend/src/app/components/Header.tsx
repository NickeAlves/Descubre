import Logo from "./Logo";
import NavBar from "./NavBar";
import "./../styles/globals.css";

const Header = () => {
  return (
    <header className="bg-transparent sticky top-0 z-[20] mx-auto flex w-full items-center justify-between p-6">
      <div className="flex items-center gap-4">
        <Logo />
        <h1 className="font-sans font-medium text-2xl ">Descubre</h1>
      </div>
      <NavBar />
    </header>
  );
};

export default Header;
