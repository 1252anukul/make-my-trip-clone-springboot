"use client";

import { useParams } from "next/navigation";
import { useEffect, useState } from "react";
import { gethotel } from "@/lib/api";
import { Button } from "@/components/ui/button";

export default function BookHotel() {
  const { id } = useParams();
  const [hotel, setHotel] = useState<any>(null);

  useEffect(() => {
    const fetchHotel = async () => {
      const hotels = await gethotel();
      const selected = hotels.find((h: any) => h._id === id || h.id === id);
      setHotel(selected);
    };

    fetchHotel();
  }, [id]);

  if (!hotel) return <p className="p-10">Loading...</p>;

  return (
    <div className="max-w-xl mx-auto mt-20 bg-white p-6 rounded-lg shadow">

      <h2 className="text-2xl font-bold mb-4">
        Book Hotel
      </h2>

      <p><b>Hotel:</b> {hotel.hotelName}</p>
      <p><b>Location:</b> {hotel.location}</p>
      <p><b>Price per Night:</b> ₹{hotel.pricePerNight}</p>

      <Button className="mt-6 w-full">
        Confirm Booking
      </Button>

    </div>
  );
}